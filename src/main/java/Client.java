import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 客户端demo
 */
public class Client {
    private SocketChannel sc = null;
    private Selector selector = null;
    private ByteArrayOutputStream baos = null;

    public static void main(String[] args) {
        new Client().start();
    }
    public void start(){
        ByteBuffer buffer = null;
        try {
            baos = new ByteArrayOutputStream();
            selector = Selector.open();
            buffer = ByteBuffer.allocate(1024);
            sc = SocketChannel.open();
            sc.configureBlocking(false);
            //这里只注册了SelectionKey.OP_READ，只关心是否能读取服务器消息
            sc.register(selector , SelectionKey.OP_READ);
            sc.connect(new InetSocketAddress("127.0.0.1" , 8899));

            //等待100毫秒直到连接上服务器
            while (!sc.finishConnect()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //新线程处理控制台输入
            new Thread(new InputThread(sc)).start();

            while (true){
                selector.select();
                if(selector == null || !selector.isOpen())
                    break;

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        while (sc.read(buffer) > 0){
                            int position = buffer.position();
                            buffer.flip();
                            baos.write(buffer.array() , 0 , position);
                            buffer.clear();
                        }
                        if(baos.size() > 0){
                            System.out.println("from server:" + new String(baos.toByteArray()));
                            baos.reset();
                        }
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class InputThread implements Runnable{
        SocketChannel sc = null;

        private InputThread(SocketChannel sc) {
            this.sc = sc;
        }

        @Override
        public void run() {
            System.out.println("客户端准备就绪，快输入消息发送给服务器吧");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                try {
                    String line = reader.readLine();
                    if(line == null || line.length() == 0){
                        sc.close();
                        selector.close();
                        baos.close();
                        break;
                    }
                    sc.write(ByteBuffer.wrap(line.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
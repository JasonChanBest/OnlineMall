import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 服务器端demo
 */
public class Server {
    public static void main(String[] args) {
        new Server().start();
    }
    public void start(){
        ServerSocketChannel ssc = null;
        Selector selector;
        try {
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(8899));
            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器启动完成，正在监听。。。");
            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        ServerSocketChannel _ssc = (ServerSocketChannel) key.channel();
                        SocketChannel sc = _ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(selector , SelectionKey.OP_READ);
                        System.out.printf("监听到客户端连接，ip:%s，端口:%s\n" , sc.socket().getInetAddress().getHostAddress() , sc.socket().getPort());
                    }else if(key.isReadable()){
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        List<Byte> list = new ArrayList<>();
                        try {
                            while (sc.read(buffer) > 0){//从套接字通道读取客户端发过来的数据直到读取完
                                buffer.flip();//ByteBuffer从写模式切换到读模式
                                while (buffer.hasRemaining()){
                                    list.add(buffer.get());
                                }
                                buffer.clear();//清空缓冲区，为下一次循环读取数据腾出空间
                            }
                            if(list.isEmpty()){//如果收到客户端消息是空的
                                System.out.println("客户端断开。。。");
                                sc.close();
                            }else{
                                byte[] bytes = new byte[list.size()];
                                for(int i = 0 ; i < bytes.length ; ++i){
                                    bytes[i] = list.get(i);
                                }
                                String str = new String(bytes);
                                System.out.println("from client:" + str);
                                ByteBuffer bf = ByteBuffer.wrap(bytes);//把客户端发过来的这条消息原样发回给客户端
                                sc.write(bf);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            sc.close();
                        }
                    }
                    iterator.remove();//这里一定要把key移除
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ssc != null) {
                try {
                    ssc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
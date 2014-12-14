package com.mall.action.picture;

import com.mall.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by Jayson on 2014/8/18.
 */
@Controller("PictureAction")
@RequestMapping("/admin/picture")
public class PictureAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureAction.class);
    private static final String PICTURE_DIR = ApplicationConfig.instance().getPicturePath();
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        String fileName = "";
        while (fileNames.hasNext()){
            MultipartFile file = request.getFile(fileNames.next());
            fileName= UUID.randomUUID().toString() + file.getOriginalFilename();
            try {
                FileCopyUtils.copy(file.getBytes() , new File(PICTURE_DIR + File.separator + fileName));
            } catch (IOException e) {
                LOGGER.error("" , e);
            }
        }
        return "{\"status\":\"success\",\"fileName\":\""+fileName+"\"}";
    }
}
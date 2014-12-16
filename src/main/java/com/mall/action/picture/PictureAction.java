package com.mall.action.picture;

import com.alibaba.fastjson.JSON;
import com.mall.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Jayson on 2014/8/18.
 */
@Controller("PictureAction")
@RequestMapping("/admin/picture")
public class PictureAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureAction.class);
    private static final String PICTURE_DIR = ApplicationConfig.instance().getRealPicturePath();
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("files") MultipartFile[] files){
        Map<String , Object> result = new HashMap<>();
        List<String> success = new ArrayList<>();
        List<String> fail = new ArrayList<>();
        String fileName = "";
        for(MultipartFile file : files){
            fileName= UUID.randomUUID().toString() + file.getOriginalFilename();
            try {
                FileCopyUtils.copy(file.getBytes() , new File(PICTURE_DIR + File.separator + fileName));
                success.add(ApplicationConfig.instance().getPicturePath() + File.separator + fileName);
            } catch (IOException e) {
                LOGGER.error("" , e);
                fail.add(file.getOriginalFilename());
            }
        }
        result.put("success" , success);
        result.put("fail" , fail);
        return JSON.toJSONString(result);
    }
}
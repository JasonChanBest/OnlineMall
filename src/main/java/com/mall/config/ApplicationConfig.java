package com.mall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Jayson on 2014/8/18.
 */
public class ApplicationConfig{
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    private Properties properties = new Properties();
    private static ApplicationConfig config = new ApplicationConfig();
    private String root = "";

    private ApplicationConfig() {
    }

    public static ApplicationConfig instance(){
        return config;
    }

    public void config(String root){
        this.root = root;
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            LOGGER.error("" , e);
        }
    }
    public String getRealPicturePath(){
        return root + properties.getProperty("picturePath");
    }
    public String getPicturePath(){
        return properties.getProperty("picturePath");
    }
    public String getRoot(){
        return root;
    }
}
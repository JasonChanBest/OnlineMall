package com.mall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Jayson on 2014/8/18.
 */
public class ApplicationConfig{
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    private Properties properties = new Properties();
    private static ApplicationConfig config = new ApplicationConfig();
    private ServletContext servletContext;

    private ApplicationConfig() {
    }

    public static ApplicationConfig instance(){
        return config;
    }

    public void config(ServletContext servletContext){
        this.servletContext = servletContext;
        String propertiesPath = servletContext.getInitParameter("propertiesPath");
        String realPath = servletContext.getRealPath(propertiesPath);
        File file = new File(realPath);
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            LOGGER.error("" , e);
        }
    }
    public String getPicturePath(){
        return servletContext.getRealPath("/") + properties.getProperty("picturePath");
    }
}
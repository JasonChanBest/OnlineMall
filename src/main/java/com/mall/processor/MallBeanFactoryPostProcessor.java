package com.mall.processor;

import com.mall.config.ApplicationConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jayson on 2014/8/18.
 */
@Component("MallBeanFactoryPostProcessor")
public class MallBeanFactoryPostProcessor implements BeanFactoryPostProcessor , ServletContextAware {
    private static final Logger LOGGER = Logger.getLogger(MallBeanFactoryPostProcessor.class);
    private ServletContext servletContext;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        try {
            String root = servletContext.getRealPath("/");
            ApplicationConfig.instance().config(root);
            String picturePath = ApplicationConfig.instance().getPicturePath();
            File pictureDir = new File(picturePath);
            if(!pictureDir.exists()) {
                pictureDir.mkdirs();
            }
        } catch (Exception e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

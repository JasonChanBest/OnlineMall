package com.mall.processor;

import com.mall.config.ApplicationConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by Jayson on 2014/8/18.
 */
@Component("MallBeanFactoryPostProcessor")
public class MallBeanFactoryPostProcessor implements BeanFactoryPostProcessor , ServletContextAware {
    private ServletContext servletContext;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ApplicationConfig.instance().config(servletContext);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

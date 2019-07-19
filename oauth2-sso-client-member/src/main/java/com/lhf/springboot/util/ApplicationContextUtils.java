package com.lhf.springboot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ApplicationContextUtils
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 16:15
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

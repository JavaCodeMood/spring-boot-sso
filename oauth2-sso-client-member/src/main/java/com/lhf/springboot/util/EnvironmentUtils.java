package com.lhf.springboot.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @ClassName: EnvironmentUtils
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 16:14
 */
@Component
public class EnvironmentUtils implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getActiveProfile(){
        if(environment.getActiveProfiles().length > 0){
            return environment.getActiveProfiles()[0];
        }
        return environment.getDefaultProfiles()[0];
    }
}

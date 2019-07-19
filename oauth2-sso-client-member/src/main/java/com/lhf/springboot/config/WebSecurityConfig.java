package com.lhf.springboot.config;

import com.lhf.springboot.util.EnvironmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: WebSecurityConfig
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 16:20
 */
@EnableOAuth2Sso
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EnvironmentUtils environmentUtils;

    @Value("${logout_url}")
    private String logout_url;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws  Exception{
        System.out.println("logout_url = " + logout_url);
        if("local".equals(environmentUtils.getActiveProfile())){
            httpSecurity.authorizeRequests().anyRequest().permitAll();
        }else {
            httpSecurity.logout().logoutSuccessUrl(logout_url)
                    .and()
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .csrf()
                    .disable();
        }
    }
}

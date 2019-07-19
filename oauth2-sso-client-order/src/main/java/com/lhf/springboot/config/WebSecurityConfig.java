package com.lhf.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: WebSecurityConfig
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 16:57
 */
@EnableOAuth2Sso
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${logout_url}")
    private String logout_url;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("logout_url = " + logout_url);
        http.logout().logoutSuccessUrl(logout_url);
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
    }
}

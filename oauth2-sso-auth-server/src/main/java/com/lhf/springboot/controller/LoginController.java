package com.lhf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: LoginController
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 15:29
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}

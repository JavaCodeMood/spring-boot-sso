package com.lhf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: OrderController
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 17:00
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/list")
    public String list() {
        return "order/list";
    }

}

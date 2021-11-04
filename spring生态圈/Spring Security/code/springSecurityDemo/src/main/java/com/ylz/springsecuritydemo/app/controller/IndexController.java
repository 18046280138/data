package com.ylz.springsecuritydemo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gwj
 * @since 2021-10-24 9:35
 */
@Controller
public class IndexController {
    @GetMapping("index")
    @ResponseBody
    public String index(){
        return "success";
    }
}

package com.shibin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public Map<String, String> json(){
        Map<String, String> map = new HashMap<>();
        map.put("name","shibin");
        return map;
    }
}

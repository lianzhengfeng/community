package com.lzf.community.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lianzhengfeng
 * @create 2021-02-03-14:18
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}

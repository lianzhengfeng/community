package com.lzf.community.controller;
import com.lzf.community.entity.User;
import com.lzf.community.service.UserService;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lianzhengfeng
 * @create 2021-02-03-14:18
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token=cookie.getValue();
                System.out.println("IndexController Token:"+token);
                User user = userService.getToken(token);
                if (user !=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}

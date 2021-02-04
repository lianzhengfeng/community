package com.lzf.community.service.impl;
import com.lzf.community.dto.GithubUser;
import com.lzf.community.entity.User;
import com.lzf.community.mapper.UserMapper;
import com.lzf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * @author lianzhengfeng
 * @create 2021-02-04-14:49
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(GithubUser githubUser, HttpServletResponse response){
        User user=new User();
        String token = UUID.randomUUID().toString();
        System.out.println("UserService Token:"+token);
        user.setToken(token);
        user.setName(githubUser.getName());
        user.setAccountId(String.valueOf(githubUser.getId()));
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userMapper.insert(user);
        response.addCookie(new Cookie("token",token));
    }

    @Override
    public User getToken(String token){
        return userMapper.selectByToken(token);
    }
}

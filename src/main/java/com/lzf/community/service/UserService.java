package com.lzf.community.service;

import com.lzf.community.dto.GithubUser;
import com.lzf.community.entity.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lianzhengfeng
 * @create 2021-02-04-14:48
 */
public interface UserService {
    void addUser(GithubUser githubUser, HttpServletResponse response);

    User getToken(String token);
}

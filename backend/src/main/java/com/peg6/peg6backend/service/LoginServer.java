package com.peg6.peg6backend.service;

import com.peg6.peg6backend.entity.User;
import com.peg6.peg6backend.mapper.UserMapper;
import com.peg6.peg6backend.resp.LoginUserResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServer {
    @Resource
    private UserMapper userMapper;

    public LoginUserResp getUserByUsernameAndPassword(String username, String password){
        User user = userMapper.getUserByUsernameAndPassword(username, password);
        LoginUserResp userResp = null;
        if(user != null)
        {
            userResp = new LoginUserResp();
            BeanUtils.copyProperties(user, userResp);
        }
        return userResp;
    }
}

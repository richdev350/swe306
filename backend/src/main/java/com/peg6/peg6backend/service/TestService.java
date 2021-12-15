package com.peg6.peg6backend.service;

import com.peg6.peg6backend.entity.User;
import com.peg6.peg6backend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    private UserMapper userMapper;

    public List<User> list(){
       return userMapper.list();
    }
}

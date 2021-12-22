package com.peg6.peg6backend.service;

import com.peg6.peg6backend.entity.User;
import com.peg6.peg6backend.mapper.UserMapper;
import com.peg6.peg6backend.req.RoomReq;
import com.peg6.peg6backend.req.UserReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServer {
    @Resource
    private UserMapper userMapper;

    public List<User> getUserList(){
        return userMapper.getUserList();
    }

    public User getUserByUserId(Integer userId){
        return userMapper.getUserByUserId(userId);
    }

    public boolean addUser(UserReq req){
        try{
            userMapper.addUser(req.getUsername(), req.getPassword(), req.getFirstName(), req.getLastName(), req.getPhoneNum(), req.getIsAdmin());
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateUser(UserReq req){
        try{
            userMapper.updateUser(req.getUserId(), req.getUsername(), req.getPassword(), req.getFirstName(), req.getLastName(), req.getPhoneNum(), req.getIsAdmin());
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteUser(Integer userId){
        try{
            userMapper.deleteUser(userId);
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

}

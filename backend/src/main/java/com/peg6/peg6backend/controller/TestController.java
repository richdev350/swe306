package com.peg6.peg6backend.controller;

import com.peg6.peg6backend.entity.Reservation;
import com.peg6.peg6backend.entity.User;
import com.peg6.peg6backend.mapper.ReservationMapper;
import com.peg6.peg6backend.mapper.UserMapper;
import com.peg6.peg6backend.resp.CommonResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ReservationMapper reservationMapper;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello World test";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name)
    {
        return "Hello World Post, " + name;
    }

    @GetMapping("/test/list")
    public List<User> list(){
        return userMapper.list();
    }

    @GetMapping("/test/lists")
    public List<Reservation> lists(){
        return reservationMapper.lists();
    }

    @GetMapping("/test/resp")
    public CommonResp list1(){
        CommonResp<List<Reservation>> resp = new CommonResp<>();
        List<Reservation> list = reservationMapper.lists();
        resp.setContent(list);
        return resp;
    }
}

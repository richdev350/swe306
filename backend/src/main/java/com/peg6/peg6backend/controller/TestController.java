package com.peg6.peg6backend.controller;

import com.peg6.peg6backend.entity.Reservation;
import com.peg6.peg6backend.req.MakeReservationReq;
import com.peg6.peg6backend.resp.CommonResp;
import com.peg6.peg6backend.resp.LoginUserResp;
import com.peg6.peg6backend.service.AuthenticateServer;
import com.peg6.peg6backend.service.LoginServer;
import com.peg6.peg6backend.service.ReservationServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private LoginServer loginServer;
    @Resource
    private AuthenticateServer authenticateServer;
    @Resource
    private ReservationServer reservationServer;

    @PostMapping("/api/login")
    public CommonResp login(String username, String password){
        CommonResp<LoginUserResp> resp = new CommonResp<>();
        LoginUserResp userResp = loginServer.getUserByUsernameAndPassword(username, password);
        if(userResp == null)
        {
            resp.setSuccess(false);
            resp.setMessage("Username or Password is Wrong!");
        }
        else{
            resp.setContent(userResp);
        }
        return resp;
    }

    @PostMapping("/api/getReservationByUserId")
    public CommonResp getReservationByUserId(String Token, String userId)
    {
        CommonResp<List<Reservation>> resp = new CommonResp();
        if(authenticateServer.authenticateToken(Token)){
            List<Reservation> context = reservationServer.getReservationByUserId(userId);
            resp.setContent(context);
        }
        else{
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;

    }

    public CommonResp makeReservation(MakeReservationReq req){
        CommonResp<String> resp = new CommonResp();

        return resp;
    }
    //TODO
//    @PostMapping("/api/getRoomList")
//    public CommonResp getRoomList(String Token){
//        CommonResp<LoginUserResp> resp = new CommonResp();
//        if(authenticateServer.authenticateToken(Token)){
//
//        }
//        else {
//
//        }
//
//        return resp;
//    }




}

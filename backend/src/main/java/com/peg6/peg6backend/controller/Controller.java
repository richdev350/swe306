package com.peg6.peg6backend.controller;

import com.peg6.peg6backend.entity.Reservation;
import com.peg6.peg6backend.entity.Room;
import com.peg6.peg6backend.req.ReservationReq;
import com.peg6.peg6backend.req.RoomReq;
import com.peg6.peg6backend.resp.CommonResp;
import com.peg6.peg6backend.resp.LoginUserResp;
import com.peg6.peg6backend.service.AuthenticateServer;
import com.peg6.peg6backend.service.LoginServer;
import com.peg6.peg6backend.service.ReservationServer;
import com.peg6.peg6backend.service.RoomServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class Controller {

    @Resource
    private LoginServer loginServer;
    @Resource
    private AuthenticateServer authenticateServer;
    @Resource
    private ReservationServer reservationServer;
    @Resource
    private RoomServer roomServer;

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

    @PostMapping("/api/getReservation")
    public CommonResp getReservationByUserId(String Token, String userId)
    {
        CommonResp<List<Reservation>> resp = new CommonResp();
        if(authenticateServer.authenticateToken(Token)){
            List<Reservation> context = reservationServer.getReservationByUserId(userId);
            //TODO: 验证学生ID的有效性
            if(context!=null){
                resp.setContent(context);
            }
            else
            {
                resp.setMessage("No Reservation");
            }

        }
        else{
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    //TODO: 学生清单格式
    @PostMapping("/api/getReservationAll")
    public CommonResp getReservationAll(String Token)
    {
        CommonResp<List<Reservation>> resp = new CommonResp();
        if(authenticateServer.authenticateToken(Token)){
            List<Reservation> context = reservationServer.getAllReservation();
            resp.setContent(context);
        }
        else{
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    //TODO:学生清单格式， 学生人数
    @PostMapping("/api/addReservation")
    public CommonResp addReservation(ReservationReq req){
        CommonResp resp = new CommonResp();
        if(authenticateServer.authenticateToken(req.getToken())){
            boolean result = reservationServer.makeReservationByUserId(req);
            if(result){
                resp.setMessage("Make Reservation Success");
            }else
            {
                resp.setSuccess(false);
                resp.setMessage("Make Reservation Failed");
            }
        }
        else
        {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/updateReservation")
    public CommonResp updateReservation(ReservationReq req, String reserveIdAI){
        CommonResp resp = new CommonResp();
        if(authenticateServer.authenticateToken(req.getToken())){
            boolean result = reservationServer.updateReservationByUserId(req, reserveIdAI);
            if(result){
                resp.setMessage("Update Reservation Success");
            }else
            {
                resp.setSuccess(false);
                resp.setMessage("Update Reservation Failed");
            }
        }
        else
        {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }


    @PostMapping("/api/deleteReservation")
    public CommonResp deleteReservationByreserveIdAI(String Token, String reserveIdAI){
        CommonResp resp = new CommonResp();
        if(authenticateServer.authenticateToken(Token)){
            int reserve = Integer.parseInt(reserveIdAI);
            boolean result = reservationServer.deleteReservationByreserveIdAI(reserve);
            if(result){
                resp.setMessage("Delete Reservation Success");
            }else
            {
                resp.setSuccess(false);
                resp.setMessage("Delete Reservation Failed");
            }
        }
        else
        {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/getRoomList")
    public CommonResp getRoomList(String Token){
        CommonResp<List<Room>> resp = new CommonResp();
        if(authenticateServer.authenticateToken(Token)){
            List<Room> content = roomServer.getRoomList();
            resp.setContent(content);
        }
        else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/getRoom")
    public CommonResp getRoom(String Token, String roomId){
        CommonResp<Room> resp = new CommonResp();

        //TODO: 验证是否有这个房间
        if(authenticateServer.authenticateToken(Token)) {
            Room content = roomServer.getRoom(roomId);
            resp.setContent(content);
        }
        else {
                resp.setSuccess(false);
                resp.setMessage("Token Wrong Or No Token");
            }
        return resp;
    }

//    @PostMapping("/api/addRoom")
//    public CommonResp addRoom(RoomReq req){
//        CommonResp resp = new CommonResp();
//        if(authenticateServer.authenticateToken(req.getToken())){
//            boolean result = roomServer
//
//        }
//        else
//        {
//            resp.setSuccess(false);
//            resp.setMessage("Token Wrong Or No Token");
//        }
//        return resp;
//    }






}

package com.peg6.peg6backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.peg6.peg6backend.entity.Reservation;
import com.peg6.peg6backend.entity.Room;
import com.peg6.peg6backend.entity.User;
import com.peg6.peg6backend.req.LoginReq;
import com.peg6.peg6backend.req.ReservationReq;
import com.peg6.peg6backend.req.RoomReq;
import com.peg6.peg6backend.req.UserReq;
import com.peg6.peg6backend.resp.CommonResp;
import com.peg6.peg6backend.resp.LoginUserResp;
import com.peg6.peg6backend.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    @Resource
    private UserServer userServer;

    @PostMapping("/api/login")
    public CommonResp login(@RequestBody LoginReq req) {
        CommonResp<LoginUserResp> resp = new CommonResp<>();
        LoginUserResp loginUserResp = loginServer.getUserByUsernameAndPassword(req.getUsername(), req.getPassword());
        if (loginUserResp == null) {
            resp.setSuccess(false);
            resp.setMessage("Username or Password is Wrong!");
        } else {
            resp.setContent(loginUserResp);
        }
        return resp;
    }

    @PostMapping("/api/getReservation")
    public CommonResp getReservation(@RequestHeader("Cookie")String Token, @RequestBody JSONObject jsonParam) {
        Integer userId = Integer.parseInt(jsonParam.getString("userId"));
        CommonResp<List<Reservation>> resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            List<Reservation> content = reservationServer.getReservationByUserId(userId);
            if (content != null) {
                resp.setContent(content);
            } else {
                resp.setMessage("No Reservation");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/getReservationAll")
    public CommonResp getReservationAll(@RequestHeader("Cookie")String Token) {
        CommonResp<List<Reservation>> resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            List<Reservation> content = reservationServer.getAllReservation();
            resp.setContent(content);
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    /*
    @param result:
        = 0 --> Make Reservation Success
        > 0 --> Student #{result} have time conflict
        = -1 --> Make Reservation Failed
     */
    @PostMapping("/api/addReservation")
    public CommonResp addReservation(@RequestHeader("Cookie")String Token, @RequestBody ReservationReq req) {
        CommonResp<Integer> resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            int result = reservationServer.makeReservationByUserId(req);
            if (result == 0) {
                resp.setMessage("Make Reservation Success");
            } else if(result < 0){
                resp.setSuccess(false);
                resp.setMessage("Make Reservation Failed");
            }else {
                resp.setSuccess(false);
                resp.setMessage("Student " + result + " have time conflict!");
                resp.setContent(result);
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/updateReservation")
    public CommonResp updateReservation(@RequestHeader("Cookie")String Token, @RequestBody ReservationReq req) {
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            boolean result = reservationServer.updateReservationByUserId(req, req.getReserveId().toString());
            if (result) {
                resp.setMessage("Update Reservation Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Update Reservation Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }


    @PostMapping("/api/deleteReservation")
    public CommonResp deleteReservation(@RequestHeader("Cookie")String Token,@RequestBody JSONObject jsonParam) {
        Integer reserveId = Integer.parseInt(jsonParam.getString("reserveId"));
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            boolean result = reservationServer.deleteReservationByReserveId(reserveId);
            if (result) {
                resp.setMessage("Delete Reservation Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Delete Reservation Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/getRoomAll")
    public CommonResp getRoomAll(String Token) {
        CommonResp<List<Room>> resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            List<Room> content = roomServer.getRoomList();
            resp.setContent(content);
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/getRoom")
    public CommonResp getRoom(String Token, String roomId) {
        CommonResp<Room> resp = new CommonResp();

        //TODO: 验证是否有这个房间
        if (authenticateServer.authenticateToken(Token)) {
            int roomID = Integer.parseInt(roomId);
            Room content = roomServer.getRoom(roomID);
            resp.setContent(content);
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/addRoom")
    public CommonResp addRoom(RoomReq req) {
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(req.getToken())) {
            boolean result = roomServer.addRoom(req);
            if (result) {
                resp.setMessage("Add Room Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Add Room Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/updateRoom")
    public CommonResp updateRoom(RoomReq req) {
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(req.getToken())) {
            boolean result = roomServer.updateRoom(req);
            if (result) {
                resp.setMessage("Update Room Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Update Room Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/deleteRoom")
    public CommonResp deleteRoom(String Token, String roomId) {
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            int roomID = Integer.parseInt(roomId);
            boolean result = roomServer.deleteRoom(roomID);
            if (result) {
                resp.setMessage("Delete Room Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Delete Room Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    //TODO
    @PostMapping("/api/getUserAll")
    public CommonResp getUserAll(String Token) {
        CommonResp<List<User>> resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            List<User> content = userServer.getUserList();
            resp.setContent(content);
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/getUser")
    public CommonResp getUser(String Token, String userId) {
        CommonResp<User> resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            int userID = Integer.parseInt(userId);
            User content = userServer.getUserByUserId(userID);
            resp.setContent(content);
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/addUser")
    public CommonResp addUser(UserReq req) {
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(req.getToken())) {
            boolean result = userServer.addUser(req);
            if (result) {
                resp.setMessage("Add User Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Add User Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/updateUser")
    public CommonResp updateUser(UserReq req) {
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(req.getToken())) {
            boolean result = userServer.updateUser(req);
            if (result) {
                resp.setMessage("Update User Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Update User Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }

    @PostMapping("/api/deleteUser")
    public CommonResp deleteUser(String Token, String userId) {
        CommonResp resp = new CommonResp();
        if (authenticateServer.authenticateToken(Token)) {
            int userID = Integer.parseInt(userId);
            boolean result = userServer.deleteUser(userID);
            if (result) {
                resp.setMessage("Delete User Success");
            } else {
                resp.setSuccess(false);
                resp.setMessage("Delete User Failed");
            }
        } else {
            resp.setSuccess(false);
            resp.setMessage("Token Wrong Or No Token");
        }
        return resp;
    }
    //TODO:按学号查学生

}

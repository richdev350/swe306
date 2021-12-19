package com.peg6.peg6backend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.peg6.peg6backend.req.ReservationReq;
import com.peg6.peg6backend.entity.Reservation;
import com.peg6.peg6backend.mapper.ReservationMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ReservationServer {
    @Resource
    private ReservationMapper reservationMapper;

    public List<Reservation> getReservationByUserId(String userId){
        return reservationMapper.getReservationByUserId(userId);
    }

    public List<Reservation> getAllReservation(){
        return reservationMapper.getAllReservation();
    }

    public boolean makeReservationByUserId(ReservationReq req){
        try{
            //TODO
            int memberNum = 0;
            JSONObject memberListJson = JSON.parseObject(req.getMemberList());
            String memberListString = (String) memberListJson.get("userId");
            List<String> memberList = Arrays.asList(memberListString);

            reservationMapper.makeReservationByUserId(req.getUserId(), req.getRoomId(), memberNum, req.getMemberList(), req.getStartTime(), req.getEndTime());
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateReservationByUserId(ReservationReq req, String reserveIdAI) {
        try{
            //TODO
            int memberNum = 0;
            reservationMapper.updateReservationByUserId(req.getUserId(), req.getRoomId(), memberNum, req.getMemberList(), req.getStartTime(), req.getEndTime(), reserveIdAI);
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }

    }

    public boolean deleteReservationByreserveIdAI(int reserveIdAI){
        try{
            reservationMapper.deleteReservationByreserveIdAI(reserveIdAI);
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}

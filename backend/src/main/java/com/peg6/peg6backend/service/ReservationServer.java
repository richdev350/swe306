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

    public List<Reservation> getReservationByUserId(Integer userId){
        String userIdString = "%,"+userId+",%";
        return reservationMapper.getReservationByUserId(userId, userIdString);
    }

    public List<Reservation> getAllReservation(){
        return reservationMapper.getAllReservation();
    }

    public int makeReservationByUserId(ReservationReq req){
        try{
            if(!isAvailable(req.getUserId().toString(), req.getStartTime(), req.getEndTime())){
                return req.getUserId();
            }
            int memberNum = 0;
            String[] memberList= req.getMemberList().split(",");

            for(String s:memberList){
                if(!s.equals("")){
                    if(!isAvailable(s, req.getStartTime(), req.getEndTime())){
                        return Integer.parseInt(s);
                    };
                }
                memberNum++;
            }

            reservationMapper.makeReservationByUserId(req.getUserId(), req.getRoomId(), memberNum, req.getMemberList(), req.getStartTime(), req.getEndTime());
            return 0;
        }catch (Exception e)
        {
            System.out.println(e);
            return -1;
        }
    }

    public boolean updateReservationByUserId(ReservationReq req, String reserveId) {
        try{
            int memberNum = 0;
            String[] memberList= req.getMemberList().split(",");
            for(String s:memberList){
                memberNum++;
            }
            reservationMapper.updateReservationByUserId(req.getUserId(), req.getRoomId(), memberNum, req.getMemberList(), req.getStartTime(), req.getEndTime(), reserveId);
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }

    }

    public boolean deleteReservationByReserveId(int reserveId){
        try{
            reservationMapper.deleteReservationByReserveId(reserveId);
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean isAvailable(String userId, String startTime, String endTime){
        List<Reservation> reservations = getReservationByUserId(Integer.parseInt(userId));
        if(reservations == null) return true;
        for(Reservation reservation:reservations){
            if(!(startTime.compareToIgnoreCase(reservation.getEndTime())>=0 || endTime.compareToIgnoreCase(reservation.getStartTime())<=0)){
                return false;
            }
        }
        return true;
    }
}

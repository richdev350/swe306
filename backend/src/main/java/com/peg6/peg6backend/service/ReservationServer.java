package com.peg6.peg6backend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.peg6.peg6backend.req.ReservationReq;
import com.peg6.peg6backend.entity.Reservation;
import com.peg6.peg6backend.mapper.ReservationMapper;

import com.peg6.peg6backend.resp.ReservationResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReservationServer {
    @Resource
    private ReservationMapper reservationMapper;

    public List<ReservationResp> getReservationByUserId(Integer userId){
        String userIdString = "%,"+userId+",%";
        List<Reservation> reservationList =  reservationMapper.getReservationByUserId(userId, userIdString);
        List<ReservationResp> reservationRespList = new ArrayList<>();
        ReservationResp reservationResp = null;
        for(Reservation r:reservationList){
            reservationResp = memberListTransToList(r);
            reservationRespList.add(reservationResp);
        }
        return reservationRespList;
    }

    public ReservationResp getReservationByReservationId(Integer reserveId){
        return memberListTransToList(reservationMapper.getReservationByReserveId(reserveId));
    }

    public List<ReservationResp> getAllReservation(){
        List<Reservation> reservationList =  reservationMapper.getAllReservation();
        List<ReservationResp> reservationRespList = new ArrayList<>();
        ReservationResp reservationResp = null;
        for(Reservation r:reservationList){
            reservationResp = memberListTransToList(r);
            reservationRespList.add(reservationResp);
        }
        return reservationRespList;
    }

    public int makeReservationByUserId(ReservationReq req){
        try{
            if(!isAvailable(req.getUserId().toString(), req.getStartTime(), req.getEndTime())){
                return req.getUserId();
            }
            int memberNum = 1;
            StringBuilder memberList = new StringBuilder(",");
            for(String s:req.getMemberList()){
                if(!s.equals("")){
                    if(!isAvailable(s, req.getStartTime(), req.getEndTime())){
                        return Integer.parseInt(s);
                    };
                }
                memberNum++;
                memberList.append(s).append(",");
            }
            reservationMapper.makeReservationByUserId(req.getUserId(), req.getRoomId(), memberNum, memberList.toString(), req.getStartTime(), req.getEndTime());
            return 0;
        }catch (Exception e)
        {
            System.out.println(e);
            return -1;
        }
    }

    public int updateReservationByUserId(ReservationReq req, String reserveId) {
        try{
            if(!isAvailable(req.getUserId().toString(), req.getStartTime(), req.getEndTime())){
                return req.getUserId();
            }

            int memberNum = 1;
            StringBuilder memberList = new StringBuilder(",");

            for(String s:req.getMemberList()){
                if(!s.equals("")){
                    if(!isAvailable(s, req.getStartTime(), req.getEndTime())){
                        return Integer.parseInt(s);
                    };
                }
                memberNum++;
                memberList.append(s).append(",");
            }
            reservationMapper.updateReservationByUserId(req.getUserId(), req.getRoomId(), memberNum, memberList.toString(), req.getStartTime(), req.getEndTime(), reserveId);
            return 0;
        }catch (Exception e)
        {
            System.out.println(e);
            return -1;
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
        List<ReservationResp> reservations = getReservationByUserId(Integer.parseInt(userId));

        if(reservations == null) return true;
        for(ReservationResp reservation:reservations){
            if(!(startTime.compareToIgnoreCase(reservation.getEndTime())>=0 || endTime.compareToIgnoreCase(reservation.getStartTime())<=0)){
                return false;
            }
        }
        return true;
    }

    public ReservationResp memberListTransToList(Reservation reservation){
        String memberListString = reservation.getMemberList();
        String[] memberLists= memberListString.split(",");
        List<String> memberList = new ArrayList<>();
        for(String s:memberLists){
            memberList.add(s);
        }
        memberList.remove(0);
        ReservationResp reservationResp = new ReservationResp();

        reservationResp.setReserveId(reservation.getreserveId());
        reservationResp.setUserId(Integer.parseInt(reservation.getUserId()));
        reservationResp.setRoomId(Integer.parseInt(reservation.getRoomId()));
        reservationResp.setMemberNum(reservation.getMemberNum());
        reservationResp.setMemberList(memberList);
        reservationResp.setStartTime(reservation.getStartTime());
        reservationResp.setEndTime(reservation.getEndTime());
        reservationResp.setStatus(reservation.getStatus());
        return reservationResp;
    }
}

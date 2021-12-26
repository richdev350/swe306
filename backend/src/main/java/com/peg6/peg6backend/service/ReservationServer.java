package com.peg6.peg6backend.service;

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
    public List<ReservationResp> getReservationByRoomId(Integer roomId){
        List<Reservation> reservationList = reservationMapper.getReservationByRoomId(roomId);
        List<ReservationResp> reservationRespList = new ArrayList<>();
        ReservationResp reservationResp = null;
        for(Reservation r:reservationList){
            reservationResp = memberListTransToList(r);
            reservationRespList.add(reservationResp);
        }
        return reservationRespList;
    }

    public ReservationResp getReservationByReservationId(Integer reserveId){
        if(reservationMapper.getReservationByReserveId(reserveId)!=null){
            return memberListTransToList(reservationMapper.getReservationByReserveId(reserveId));
        }
        return null;
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
            if(!isUserAvailable(req.getUserId().toString(), req.getStartTime(), req.getEndTime())){
                return req.getUserId();
            }
            if(!isRoomAvailable(req.getRoomId().toString(), req.getStartTime(), req.getEndTime())){
                return (req.getRoomId()*-1)-1;
            }
            int memberNum = 1;
            StringBuilder memberList = new StringBuilder(",");
            for(String s:req.getMemberList()){
                if(!s.equals("")){
                    if(!isUserAvailable(s, req.getStartTime(), req.getEndTime())){
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
            if(!isUserAvailable(req.getUserId().toString(), req.getStartTime(), req.getEndTime())){
                return req.getUserId();
            }
            if(!isRoomAvailable(req.getRoomId().toString(), req.getStartTime(), req.getEndTime())){
                return (req.getRoomId()*-1)-1;
            }
            int memberNum = 1;
            StringBuilder memberList = new StringBuilder(",");

            for(String s:req.getMemberList()){
                if(!s.equals("")){
                    if(!isUserAvailable(s, req.getStartTime(), req.getEndTime())){
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

    public boolean isUserAvailable(String userId, String startTime, String endTime){
        List<ReservationResp> reservations = getReservationByUserId(Integer.parseInt(userId));

        if(reservations == null) return true;
        for(ReservationResp reservation:reservations){
            if(!(startTime.compareToIgnoreCase(reservation.getEndTime())>=0 || endTime.compareToIgnoreCase(reservation.getStartTime())<=0)){
                return false;
            }
        }
        return true;
    }

    public boolean isRoomAvailable(String roomId, String startTime, String endTime){
        List<ReservationResp> reservations = getReservationByRoomId(Integer.parseInt(roomId));

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

        reservationResp.setReserveId(reservation.getReserveId());
        reservationResp.setUserId(Integer.parseInt(reservation.getUserId()));
        reservationResp.setRoomId(Integer.parseInt(reservation.getRoomId()));
        reservationResp.setMemberNum(reservation.getMemberNum());
        reservationResp.setMemberList(memberList);
        reservationResp.setStartTime(reservation.getStartTime());
        reservationResp.setEndTime(reservation.getEndTime());
        reservationResp.setStatus(reservation.getStatus());
        return reservationResp;
    }

    public List<Integer> roomSchedule(Integer roomId, String day){
        boolean flag = true;
        List<Integer> schedule = new ArrayList<>();
        List<String> timeStringList = new ArrayList<>();
        for(int i=8;i<23;i++){
            String Temps;
            if (i >= 10) {
                Temps = i + ":01";
                timeStringList.add(Temps);
                Temps = i + ":31";
            } else {
                Temps = "0" + i + ":01";
                timeStringList.add(Temps);
                Temps = "0" + i + ":31";
            }
            timeStringList.add(Temps);

        }
        String DayString = "%" + day + "%";
        List<Reservation> reservations = reservationMapper.getReservationByRoomIdAndDay(roomId, DayString);
        for(String s:timeStringList){
            String Temp = day + " " + s;
            System.out.println(Temp);
            flag = true;
            for(Reservation r:reservations){
                if(Temp.compareToIgnoreCase(r.getStartTime())>0 && Temp.compareToIgnoreCase(r.getEndTime())<0){
                    schedule.add(1);
                    System.out.println(1);
                    flag = false;
                    break;
                }
            }
            if(flag){
                schedule.add(0);
                System.out.println(0);
            }
        }
        System.out.println(schedule);
        return schedule;
    }
}

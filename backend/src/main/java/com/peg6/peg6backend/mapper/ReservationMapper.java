package com.peg6.peg6backend.mapper;

import com.alibaba.fastjson.JSON;
import com.peg6.peg6backend.entity.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservationMapper {
    public List<Reservation> getReservationByUserId(@Param("userId") String userId);

    public List<Reservation> getAllReservation();

    public void makeReservationByUserId(@Param("userId") String userId, @Param("roomId") String roomId,
                                           @Param("memberNum") int memberNum, @Param("memberList") String memberList,
                                           @Param("startTime") String startTime, @Param("endTime") String endTime);

    public void updateReservationByUserId(@Param("userId") String userId, @Param("roomId") String roomId,
                                          @Param("memberNum") int memberNum, @Param("memberList") String memberList,
                                          @Param("startTime") String startTime, @Param("endTime") String endTime,
                                          @Param("reserveIdAI") String reserveIdAI);

    public void deleteReservationByreserveIdAI(@Param("reserveIdAI") int reserveIdAI);


}


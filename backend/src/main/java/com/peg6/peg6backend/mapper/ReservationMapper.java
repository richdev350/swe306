package com.peg6.peg6backend.mapper;

import com.peg6.peg6backend.entity.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservationMapper {
    public List<Reservation> getReservationByUserId(@Param("userId") Integer userId, @Param("userIdString")String userIdString);

    public List<Reservation> getAllReservation();

    public Reservation getReservationByReserveId(@Param("reserveId") Integer reserveId);

    public void makeReservationByUserId(@Param("userId") Integer userId, @Param("roomId") Integer roomId,
                                           @Param("memberNum") Integer memberNum, @Param("memberList") String memberList,
                                           @Param("startTime") String startTime, @Param("endTime") String endTime);

    public void updateReservationByUserId(@Param("userId") Integer userId, @Param("roomId") Integer roomId,
                                          @Param("memberNum") Integer memberNum, @Param("memberList") String memberList,
                                          @Param("startTime") String startTime, @Param("endTime") String endTime,
                                          @Param("reserveId") String reserveId);

    public void deleteReservationByReserveId(@Param("reserveId") Integer reserveId);


}


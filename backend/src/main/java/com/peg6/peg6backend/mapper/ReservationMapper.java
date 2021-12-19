package com.peg6.peg6backend.mapper;

import com.peg6.peg6backend.entity.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservationMapper {
    public List<Reservation> getReservationByUserId(@Param("userId") String userId);
}

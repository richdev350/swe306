package com.peg6.peg6backend.service;

import com.peg6.peg6backend.entity.Reservation;
import com.peg6.peg6backend.mapper.ReservationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReservationServer {
    @Resource
    private ReservationMapper reservationMapper;

    public List<Reservation> getReservationByUserId(String userId){
        return reservationMapper.getReservationByUserId(userId);
    }
}

package com.peg6.peg6backend.service;

import com.peg6.peg6backend.entity.Room;
import com.peg6.peg6backend.mapper.RoomMapper;
import com.peg6.peg6backend.req.RoomReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomServer {
    @Resource
    private RoomMapper roomMapper;

    public List<Room> getRoomList(){
        return roomMapper.getRoomList();
    }

    public Room getRoom(Integer roomId){
        return roomMapper.getRoom(roomId);
    }

    public Room getRoomByRoomNo(String roomNo){
        return roomMapper.getRoomByRoomNo(roomNo);
    }

    public boolean addRoom(RoomReq req){
        try{
            roomMapper.addRoom(req.getRoomNo(), req.getLocation(), req.getStatus(), req.getRoomName(), req.getCapacityMin(), req.getCapacityMax());
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateRoom(RoomReq req){
        try{
            roomMapper.updateRoom(req.getRoomId(), req.getRoomNo(), req.getLocation(), req.getStatus(), req.getRoomName(), req.getCapacityMin(), req.getCapacityMax());
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteRoom(Integer roomId){
        try{
            roomMapper.deleteRoom(roomId);
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}

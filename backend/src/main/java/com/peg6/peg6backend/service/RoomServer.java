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

    public Room getRoom(String roomId){
        Room room = roomMapper.getRoom(roomId);
        return room;
    }

    public boolean addRoom(RoomReq req){
        try{

            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateRoom(RoomReq req){
        try{

            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteRoom(String roomId){
        try{

            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}

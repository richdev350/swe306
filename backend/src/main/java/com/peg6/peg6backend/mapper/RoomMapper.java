package com.peg6.peg6backend.mapper;

import com.peg6.peg6backend.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    public List<Room> getRoomList();

    public Room getRoom(@Param("roomId") Integer roomId);

    public Room getRoomByRoomNo(@Param("roomNo") String roomNo);

    public void addRoom(@Param("roomNo") String roomNo, @Param("location") String location, @Param("status") int status,
                        @Param("roomName") String roomName, @Param("capacityMin") int capacityMin,
                        @Param("capacityMax") int capacityMax);

    public void updateRoom(@Param("roomId") Integer roomId, @Param("roomNo") String roomNo, @Param("location") String location, @Param("status") int status,
                           @Param("roomName") String roomName, @Param("capacityMin") int capacityMin,
                           @Param("capacityMax") int capacityMax);

    public void deleteRoom(@Param("roomId") Integer roomId);
}

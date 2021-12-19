package com.peg6.peg6backend.mapper;

import com.peg6.peg6backend.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    public List<Room> getRoomList();

    public Room getRoom(@Param("roomId") String roomId);

    public void addRoom(@Param("roomId") String roomId, @Param("location") String location, @Param("status") int status,
                        @Param("roomName") String roomName, @Param("capacityMin") int capacityMin,
                        @Param("capacityMax") int capacityMax);

    public void updateRoom();

    public void deleteRoom(@Param("roomId") String roomId);
}

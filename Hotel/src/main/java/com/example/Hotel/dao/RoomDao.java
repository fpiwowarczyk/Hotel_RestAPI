package com.example.Hotel.dao;

import com.example.Hotel.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomDao {

    int insertRoom(Room room);

    List<Room> selectAllRooms(); //List of rooms

    Optional<Room> selectRoomByNr(Integer nr);

    int deleteRoomByNr(Integer nr);

    int updateRoomByNr(Integer nr, Room newRoom);
}

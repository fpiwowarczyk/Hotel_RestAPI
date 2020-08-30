package com.example.Hotel.service;


import com.example.Hotel.dao.RoomDao;
import com.example.Hotel.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomDao roomDao;

    @Autowired
    public RoomService(@Qualifier("fakeRoomDao")RoomDao roomDao){this.roomDao=roomDao;}
    public int addRoom(Room room) {return roomDao.insertRoom(room);}

    public List<Room> getAllRooms() {return roomDao.selectAllRooms();}

    public Optional<Room> getRoomByNr(Integer nr){return roomDao.selectRoomByNr(nr);}

    public int deleteRoom(Integer nr) {return roomDao.deleteRoomByNr(nr);}

    public int updateRoom(Integer nr, Room newRoom){return roomDao.updateRoomByNr(nr,newRoom);}

}

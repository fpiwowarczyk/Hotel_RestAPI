package com.example.Hotel.dao;


import com.example.Hotel.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeRoomDao")
public class FakeRoomAccessService implements RoomDao{

    public static List<Room> DB = new ArrayList<>();

    @Override
    public int insertRoom(Room room) {
        DB.add(new Room(room.getNr(),room.getPrice(),room.getCapacity(),room.getFree()));
        return 1;
    }

    @Override
    public List<Room> selectAllRooms() {
        return DB;
    }

    @Override
    public Optional<Room> selectRoomByNr(Integer nr) {
        return DB.stream()
                .filter(room -> room.getNr().equals(nr))
                .findFirst();
    }

    @Override
    public int deleteRoomByNr(Integer nr) {
        Optional<Room> roomMaybe = selectRoomByNr(nr);
        if(roomMaybe.isEmpty()){
            return 0;
        }
        DB.remove(roomMaybe.get());
            return 1;
    }

    @Override
    public int updateRoomByNr(Integer nr, Room update) {
        return selectRoomByNr(nr)
                .map(room ->{
                    int indexOfRoomToUpdate = DB.indexOf(room);
                    if(indexOfRoomToUpdate >= 0){
                        DB.set(indexOfRoomToUpdate,new Room(update.getNr(),update.getPrice(),update.getCapacity(),update.getFree()));
                        return 1;
                    } else {
                        return 0;
                    }
                }).orElse(0);
    }
}

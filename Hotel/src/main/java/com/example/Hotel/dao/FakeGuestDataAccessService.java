package com.example.Hotel.dao;


import com.example.Hotel.model.Guest;
import com.example.Hotel.model.GuestRoomChange;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeGuestDao")
public class FakeGuestDataAccessService implements GuestDao{
    public static List<Guest> DB = new ArrayList<>();

    @Override
    public int insertGuest(Guest guest) {
        DB.add(new Guest(guest.getIdCardNr(),guest.getName(),guest.getSurname(),guest.getRoom()));
        return 1;
    }

    @Override
    public List<Guest> selectAllGuests() {
        return DB;
    }

    @Override
    public Optional<Guest> selectGuestById(String idCardNr) {
        return DB.stream()
                .filter(guest -> guest.getIdCardNr().equals(idCardNr))
                .findFirst();
    }

    @Override
    public int deleteGuestById(String idCardNr) {
       Optional<Guest> guestMaybe = selectGuestById(idCardNr);
       if(guestMaybe.isEmpty()){
           return 0;
       }
       DB.remove(guestMaybe.get());
       return 1;
    }

    @Override
    public int updateGuestById(String idCardNr, Guest update) {
        return selectGuestById(idCardNr)
                .map(guest ->{
                    int indexOfGuestToUpdate = DB.indexOf(guest);
                    if(indexOfGuestToUpdate >= 0){
                        DB.set(indexOfGuestToUpdate, new Guest(update.getIdCardNr(),update.getName(),update.getSurname(),update.getRoom()));
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .orElse(0);
    }

    @Override
    public int updateRoomGuest(String idCardNr, GuestRoomChange room) {
       return selectGuestById(idCardNr)
               .map(guest -> {
                   int indexOfGuestToUpdate = DB.indexOf(guest);
                   if(indexOfGuestToUpdate >=0){
                       DB.set(indexOfGuestToUpdate, new Guest(guest.getIdCardNr(),guest.getName(),guest.getSurname(), room.getNr()));
                       return 1;
                   } else {
                       return 0;
                   }
               })
               .orElse(0);
    }
}

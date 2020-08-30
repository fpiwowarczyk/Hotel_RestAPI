package com.example.Hotel.dao;


import com.example.Hotel.model.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeGuestDao")
public class FakeGuestDataAccessService implements GuestDao{
    public static List<Guest> DB = new ArrayList<>();

    @Override
    public int insertGuest(UUID id, Guest guest) {
        DB.add(new Guest(id,guest.getName(),guest.getSurname()));
        return 1;
    }

    @Override
    public List<Guest> selectAllGuests() {
        return DB;
    }

    @Override
    public Optional<Guest> selectGuestById(UUID id) {
        return DB.stream()
                .filter(guest -> guest.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteGuestById(UUID id) {
       Optional<Guest> guestMaybe = selectGuestById(id);
       if(guestMaybe.isEmpty()){
           return 0;
       }
       DB.remove(guestMaybe.get());
       return 1;
    }

    @Override
    public int updateGuestById(UUID id, Guest update) {
        return selectGuestById(id)
                .map(guest ->{
                    int indexOfGuestToUpdate = DB.indexOf(guest);
                    if(indexOfGuestToUpdate >= 0){
                        DB.set(indexOfGuestToUpdate, new Guest(id,update.getName(),update.getSurname()));
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .orElse(0);
    }

    //@Override
    //public int updatePartGuestById(UUID id, Guest guest) {
    //    return 0;
    //}
}

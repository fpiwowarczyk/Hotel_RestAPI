package com.example.Hotel.service;

import com.example.Hotel.dao.GuestDao;
import com.example.Hotel.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class GuestService {

    private final GuestDao guestDao;

    @Autowired
    public GuestService(@Qualifier("fakeDao")GuestDao guestDao) {this.guestDao = guestDao;}
    public int addGuest(Guest guest) {return guestDao.insertGuest(guest);}

    public List<Guest> getAllGuests() {return  guestDao.selectAllGuests();}

    public Optional<Guest> getGuestById(UUID id){return guestDao.selectGuestById(id);}

    public int deleteGuest(UUID id) {return guestDao.deleteGuestById(id);}

    public int updateGuest(UUID id,Guest newGuest){return guestDao.updateGuestById(id,newGuest);}
}

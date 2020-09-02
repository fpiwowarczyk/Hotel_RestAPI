package com.example.Hotel.service;

import com.example.Hotel.dao.GuestDao;
import com.example.Hotel.model.Guest;
import com.example.Hotel.model.GuestRoomChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestDao guestDao;

    @Autowired
    public GuestService(@Qualifier("fakeGuestDao")GuestDao guestDao) {this.guestDao = guestDao;}
    public int addGuest(Guest guest) {return guestDao.insertGuest(guest);}

    public List<Guest> getAllGuests() {return  guestDao.selectAllGuests();}

    public Optional<Guest> getGuestById(String idCardNr){return guestDao.selectGuestById(idCardNr);}

    public int deleteGuest(String idCardNr) {return guestDao.deleteGuestById(idCardNr);}

    public int updateGuest(String idCardNr,Guest newGuest){return guestDao.updateGuestById(idCardNr,newGuest);}

    public int updateRoomGuest(String idCardNr, GuestRoomChange room){return guestDao.updateRoomGuest(idCardNr,room);}
}

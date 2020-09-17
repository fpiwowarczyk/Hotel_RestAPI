package com.example.Hotel.dao;


import com.example.Hotel.model.Guest;
import com.example.Hotel.model.GuestRoomChange;

import java.util.List;
import java.util.Optional;

public interface GuestDao {

    int insertGuest(Guest guest);// add guest

    List<Guest> selectAllGuests(); // List of guests

    Optional<Guest> selectGuestById(String idCardNr); //info about guest

    int deleteGuestById(String idCardNr); // Eof

    int updateGuestById(String idCardNr,Guest newGuest); // update

    int updateRoomGuest(String idCardNr, GuestRoomChange room); //update part
} // Guest DAO

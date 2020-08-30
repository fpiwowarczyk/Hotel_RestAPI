package com.example.Hotel.dao;

import com.example.Hotel.model.Guest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GuestDao {

    int insertGuest(UUID id, Guest guest);
    default int insertGuest(Guest guest){
        UUID id = UUID.randomUUID();
        return insertGuest(id,guest);
    } // add guest

    List<Guest> selectAllGuests(); // List of guests

    Optional<Guest> selectGuestById(UUID id); //info about guest

    int deleteGuestById(UUID id); // Eof

    int updateGuestById(UUID id,Guest newGuest); // update

   // int updatePartGuestById(UUID id, Guest guest); //update part
} // Guest DAO

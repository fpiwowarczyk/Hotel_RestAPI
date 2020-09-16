package com.example.Hotel.Guest;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class GuestDataAccessService implements GuestDao{
    @Override
    public int insertGuest(Guest guest) {
        return 0;
    }

    @Override
    public List<Guest> selectAllGuests() {
        return List.of(new Guest("12334","From POSTGRES DB","From postgres dB",101));
    }

    @Override
    public Optional<Guest> selectGuestById(String idCardNr) {
        return Optional.empty();
    }

    @Override
    public int deleteGuestById(String idCardNr) {
        return 0;
    }

    @Override
    public int updateGuestById(String idCardNr, Guest newGuest) {
        return 0;
    }

    @Override
    public int updateRoomGuest(String idCardNr, GuestRoomChange room) {
        return 0;
    }
}

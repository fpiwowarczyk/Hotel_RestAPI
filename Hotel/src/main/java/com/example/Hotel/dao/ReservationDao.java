package com.example.Hotel.dao;

import com.example.Hotel.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationDao {
    int insertReservation(UUID id, Reservation reservation);
    default int insertReservation(Reservation reservation){
        UUID id = UUID.randomUUID();
        return insertReservation(id,reservation);
    }

    List<Reservation> selectAllReservations();

    Optional<Reservation> selectReservationById(UUID id);

    int deleteReservationById(UUID id);

    int updateReservationById(UUID id,Reservation newReservation);
}

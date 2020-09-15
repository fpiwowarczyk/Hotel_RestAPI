package com.example.Hotel.dao;

import com.example.Hotel.model.Arch;
import com.example.Hotel.model.Reservation;
import com.example.Hotel.model.ReservationDatesChange;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeReservationDao")
public class FakeReservationAccessService implements ReservationDao {
    private static FakeArchDataAccessService arch;
    public static List<Reservation> DB = new ArrayList<>();


    @Override
    public int insertReservation(UUID id, Reservation reservation) {
        DB.add(new Reservation(id,reservation.getStart(),reservation.getEnd(),reservation.getRoomMates()));
        return 1;
    }

    @Override
    public List<Reservation> selectAllReservations() {
        return DB;
    }

    @Override
    public Optional<Reservation> selectReservationById(UUID id) {
        return DB.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteReservationById(UUID id) {
        Optional<Reservation> reservationMaybe = selectReservationById(id);
        if(reservationMaybe.isEmpty())
            return 0;
        DB.remove(reservationMaybe.get());
        return 1;
    }

    @Override
    public int updateReservationById(UUID id, Reservation update) {
        return selectReservationById(id)
                .map(reservation -> {
                    int indexOfReservationToUpdate = DB.indexOf(reservation);
                    if(indexOfReservationToUpdate >= 0){
                        DB.set(indexOfReservationToUpdate, new Reservation(id,update.getStart(),update.getEnd(),update.getRoomMates()));
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .orElse(0);
    }

    @Override
    public int updateReservationDateById(UUID id, ReservationDatesChange newDate) {
        return selectReservationById(id)
                .map(reservation -> {
                    int indexOfReservationToUpdate =DB.indexOf(reservation);
                    if(indexOfReservationToUpdate >=0){
                        DB.set(indexOfReservationToUpdate,new Reservation(id,newDate.getStart(),newDate.getEnd(),reservation.getRoomMates()));
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .orElse(0);
    }


}

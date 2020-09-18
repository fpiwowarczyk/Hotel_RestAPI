package com.example.Hotel.service;


import com.example.Hotel.Entity.ReservationEntity;
import com.example.Hotel.dao.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    public ReservationEntity addReservation(ReservationEntity reservation){
        reservation.setId(UUID.randomUUID().toString());
        return reservationRepository.save(reservation);
    }

    public Page<ReservationEntity> getAllReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    public Optional<ReservationEntity> getReservationById(String id){return reservationRepository.findById(id);}

    public ResponseEntity<ReservationEntity> deleteReservationById(String id) {
        ReservationEntity reservation = reservationRepository.findById(id).orElse(null);
        if(reservation!=null){
            reservationRepository.deleteById(id);
            return new ResponseEntity<>(null,HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<EntityModel<ReservationEntity>> updateReservationById(String id, ReservationEntity newReservation){
        ReservationEntity reservation = reservationRepository.findById(id).orElse(newReservation);
        System.out.println(newReservation);
        System.out.println("Id:"+newReservation.getId());
        System.out.println("Start_of"+newReservation.getStart_of()+"  End_Of"+newReservation.getEnd_of()+"    Id card nr:"+newReservation.getGuest_Id_Card_Nr());
        if(!StringUtils.isEmpty(newReservation.getEnd_of())&&
        !StringUtils.isEmpty(newReservation.getStart_of())&&
        !StringUtils.isEmpty(newReservation.getGuest_Id_Card_Nr())){
            reservation.setId(newReservation.getId());
            reservation.setStart_of(newReservation.getStart_of());
            reservation.setEnd_of(newReservation.getEnd_of());
            reservation.setGuest_Id_Card_Nr(newReservation.getGuest_Id_Card_Nr());
            EntityModel<ReservationEntity> entityEntityModel = EntityModel.of(reservationRepository.save(reservation));
            return new ResponseEntity<>(entityEntityModel,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}

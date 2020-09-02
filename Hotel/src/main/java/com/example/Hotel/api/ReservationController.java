package com.example.Hotel.api;


import com.example.Hotel.model.Reservation;
import com.example.Hotel.model.ReservationDatesChange;
import com.example.Hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("/reservation")
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {this.reservationService = reservationService;}

    @PostMapping
    public void addReservation(@Valid @NotNull @RequestBody Reservation reservation){ reservationService.addReservation(reservation);}

    @GetMapping
    public List<Reservation> getAllReservations() {return reservationService.getAllReservations();}

    @GetMapping(path="{id}")
    public Reservation getReservationById(@PathVariable("id") UUID id){
        return reservationService.getReservationById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deleteReservationById(@PathVariable("id") UUID id){
        reservationService.deleteReservation(id);
    }

    @PutMapping(path="{id}")
    public void updateReservation(@PathVariable("id")UUID id,@Valid @NotNull @RequestBody Reservation reservationToUpdate){
        reservationService.updateReservation(id,reservationToUpdate);
    }

    @PatchMapping(path="{id}")
    public void updateReservationDate(@PathVariable("id") UUID id, @RequestBody ReservationDatesChange newDate){
        reservationService.updateReservationDate(id,newDate);
    }

}

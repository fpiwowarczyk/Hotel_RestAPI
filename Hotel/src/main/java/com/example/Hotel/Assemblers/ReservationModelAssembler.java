package com.example.Hotel.Assemblers;

import com.example.Hotel.Entity.ReservationEntity;
import com.example.Hotel.api.ReservationController;
import com.example.Hotel.api.RoomController;
import com.example.Hotel.model.ReservationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class ReservationModelAssembler extends RepresentationModelAssemblerSupport<ReservationEntity, ReservationModel> {

    public ReservationModelAssembler(){super(ReservationController.class,ReservationModel.class);}

    @Override
    public ReservationModel toModel(ReservationEntity entity) {
        ReservationModel reservationModel = instantiateModel(entity);
        reservationModel.add(linkTo(ReservationController.class).slash(entity.getId())
                        .withSelfRel());
        reservationModel.setId(entity.getId());
        reservationModel.setStart_of(entity.getStart_of());
        reservationModel.setEnd_of(entity.getEnd_of());
        reservationModel.setGuestIdCardNr(entity.getGuest_Id_Card_Nr());

        return reservationModel;
    }
}

package com.example.Hotel.Assemblers;


import com.example.Hotel.Entity.RoomEntity;
import com.example.Hotel.api.RoomController;
import com.example.Hotel.model.RoomModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class RoomModelAssembler extends RepresentationModelAssemblerSupport<RoomEntity,RoomModel>{

    public RoomModelAssembler(){ super(RoomController.class,RoomModel.class);}

    @Override
    public RoomModel toModel(RoomEntity entity) {
        RoomModel roomModel = instantiateModel(entity);
        roomModel.add(linkTo(RoomController.class).slash(entity.getNr())
                .withSelfRel());
        roomModel.setNr(entity.getNr());
        roomModel.setPrice(entity.getPrice());
        roomModel.setCapacity(entity.getCapacity());
        roomModel.setFree(entity.getFree());
        return roomModel;
    }
}
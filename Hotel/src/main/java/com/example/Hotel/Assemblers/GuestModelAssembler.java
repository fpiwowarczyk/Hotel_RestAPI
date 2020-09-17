package com.example.Hotel.Assemblers;

import com.example.Hotel.Entity.GuestEntity;
import com.example.Hotel.api.GuestController;
import com.example.Hotel.model.GuestModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class GuestModelAssembler extends RepresentationModelAssemblerSupport<GuestEntity, GuestModel> {

    public GuestModelAssembler(){
        super(GuestController.class,GuestModel.class);
    }

    @Override
    public GuestModel toModel(GuestEntity entity){
        GuestModel guestModel = instantiateModel(entity);
        guestModel.add(linkTo(GuestController.class).slash((entity.getIdCardNr()))
                .withSelfRel());

        guestModel.setIdCardNr(entity.getIdCardNr());
        guestModel.setName(entity.getName());
        guestModel.setSurname(entity.getSurname());
        guestModel.setRoom(entity.getRoom());

        return guestModel;
    }

}

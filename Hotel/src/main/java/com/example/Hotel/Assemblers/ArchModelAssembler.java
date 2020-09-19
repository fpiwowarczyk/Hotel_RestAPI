package com.example.Hotel.Assemblers;

import com.example.Hotel.Entity.ArchEntity;

import com.example.Hotel.api.ArchController;
import com.example.Hotel.model.ArchModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class ArchModelAssembler extends RepresentationModelAssemblerSupport<ArchEntity, ArchModel> {

    public ArchModelAssembler(){super(ArchController.class,ArchModel.class);}

    @Override
    public ArchModel toModel(ArchEntity entity) {
        ArchModel archModel = instantiateModel(entity);
        archModel.add(linkTo(ArchController.class).slash(entity.getId())
                .withSelfRel());
        archModel.setId(entity.getId());
        archModel.setStart_of(entity.getStart_of());
        archModel.setEnd_of(entity.getEnd_of());
        archModel.setGuestIdCardNr(entity.getGuest_Id_Card_Nr());

        return archModel;
    }
}

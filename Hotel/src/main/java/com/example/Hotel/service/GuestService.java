package com.example.Hotel.service;


import com.example.Hotel.Entity.GuestEntity;
import com.example.Hotel.api.GuestController;
import com.example.Hotel.dao.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;


    public ResponseEntity<Link> addGuest(GuestEntity guest) {
        Link link =  linkTo(GuestController.class).slash(guest.getIdCardNr()).withSelfRel();
        guestRepository.save(guest);
        return new ResponseEntity<>(link,HttpStatus.CREATED);
    }

    public Page<GuestEntity> getAllGuests(Pageable pageable){
        return guestRepository.findAll(pageable);
    }

    public Optional<GuestEntity> getGuestById(String idCardNr){
        Link link = linkTo(GuestController.class).slash(idCardNr).withSelfRel();
        Link linkAll = linkTo(GuestController.class).withRel("All Guests");
        return guestRepository.findById(idCardNr);
    }

    public ResponseEntity<GuestEntity> deleteGuestById(String idCardNr){

        GuestEntity guest = guestRepository.findById(idCardNr).orElse(null);
        if(guest != null){
            guestRepository.deleteById(idCardNr);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<EntityModel<GuestEntity>> updateGuestById(String idCardNr,GuestEntity newGuest){
        GuestEntity guest = guestRepository.findById(idCardNr).orElse(newGuest);
        if(!StringUtils.isEmpty(newGuest.getName())&&
            !StringUtils.isEmpty(newGuest.getSurname())&&
            newGuest.getRoom()!=null){
            guest.setName(newGuest.getName());
            guest.setSurname(newGuest.getSurname());
            guest.setRoom(newGuest.getRoom());
            EntityModel<GuestEntity> entityEntityModel = EntityModel.of(guestRepository.save(guest));
            return new ResponseEntity<>(entityEntityModel,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<GuestEntity> updatePartGuestById(String idCardNr, GuestEntity newGuest){
        GuestEntity guest = guestRepository.findById(idCardNr).orElse(null);
        if(guest != null) {
            Optional.ofNullable(newGuest.getName())
                    .filter(name -> !StringUtils.isEmpty(name))
                    .map (StringUtils::capitalize)
                    .ifPresent(name -> guest.setName(newGuest.getName()));
            Optional.ofNullable(newGuest.getSurname())
                    .filter(surname -> !StringUtils.isEmpty(surname))
                    .map(StringUtils::capitalize)
                    .ifPresent(surname ->guest.setSurname(newGuest.getSurname()));
            Optional.ofNullable(newGuest.getRoom())
                    .filter(room -> room!=null)
                    .ifPresent(room -> guest.setRoom(newGuest.getRoom()));
            return new ResponseEntity<>(guestRepository.save(guest),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}

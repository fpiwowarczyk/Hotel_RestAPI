package com.example.Hotel.service;


import com.example.Hotel.Entity.GuestEntity;
import com.example.Hotel.dao.GuestDao;
import com.example.Hotel.dao.GuestRepository;
import com.example.Hotel.model.Guest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestDao guestDao;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    public GuestService(@Qualifier("postgres")GuestDao guestDao) {this.guestDao = guestDao;}

    public GuestEntity addGuest(GuestEntity guest) {
        return guestRepository.save(guest);
    }

    public Page<GuestEntity> getAllGuests(Pageable pageable){
        return guestRepository.findAll(pageable);
    }

    public Optional<GuestEntity> getGuestById(String idCardNr){
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
    public ResponseEntity<EntityModel<GuestEntity>> updateGuestById(String idCardNr,GuestEntity newGuest){ // Nie dziala
        GuestEntity guest = guestRepository.findById(idCardNr).orElse(newGuest);
        if(!StringUtils.isEmpty(newGuest.getIdCardNr())&&
            !StringUtils.isEmpty(newGuest.getName())&&
            !StringUtils.isEmpty(newGuest.getSurname())&&
            !(newGuest.getRoom()==null)){
            guest.setIdCardNr(idCardNr);
            //Link link = linkTo(CarController.class).slash(client.getId()).withSelfRel(); TODO
            //Link linkAll = linkTo(CarController.class).withRel("All clients"); TODO
            EntityModel<GuestEntity> guestEntityEntityModel = EntityModel.of(guestRepository.save(guest)/*link,linkall*/);
            new ResponseEntity<>(guestEntityEntityModel,HttpStatus.CREATED);
        } else if (!StringUtils.isEmpty(newGuest.getName())&&
                    !StringUtils.isEmpty(newGuest.getSurname())&&
                    !(newGuest.getRoom()==null)){
            guest.setName(newGuest.getName());
            guest.setSurname(newGuest.getSurname());
            guest.setRoom(newGuest.getRoom());
            new ResponseEntity<>(guestRepository.save(guest),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<GuestEntity> updatePartGuestById(String idCardNr, Guest newGuest){
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

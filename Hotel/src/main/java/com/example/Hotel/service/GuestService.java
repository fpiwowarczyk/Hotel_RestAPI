package com.example.Hotel.service;


import com.example.Hotel.Entity.GuestEntity;
import com.example.Hotel.dao.GuestDao;
import com.example.Hotel.dao.GuestRepository;
import com.example.Hotel.model.Guest;
import com.example.Hotel.model.GuestRoomChange;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

        public int updateGuest(String idCardNr,Guest newGuest){
            GuestEntity guest = guestRepository.findById(idCardNr).orElse(new GuestEntity());
            if(guest.getIdCardNr()==null){
                guest.setIdCardNr(idCardNr);
            }
            if(newGuest.getName()!= null && newGuest.getSurname() != null && newGuest.getRoom()!=null){
                guest.setName(newGuest.getName());
                guest.setSurname(newGuest.getSurname());
                guest.setRoom(newGuest.getRoom());
                guestRepository.save(guest);
                return 1;
            }
            return 0;
        }

    public int updateRoomGuest(String idCardNr, GuestRoomChange room){return guestDao.updateRoomGuest(idCardNr,room);}//TODO
}

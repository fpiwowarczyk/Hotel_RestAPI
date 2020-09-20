package com.example.Hotel.service;


import com.example.Hotel.Entity.RoomEntity;
import com.example.Hotel.api.RoomController;
import com.example.Hotel.dao.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class RoomService {


    @Autowired
    private RoomRepository roomRepository;

    public ResponseEntity<Link> addRoom(RoomEntity room) {
        Link link = linkTo(RoomController.class).slash(room.getNr()).withSelfRel();
        roomRepository.save(room);
        return new ResponseEntity<>(link,HttpStatus.CREATED);
    }

    public Page<RoomEntity> getAllRooms(Pageable pageable) {return roomRepository.findAll(pageable);}

    public Optional<RoomEntity> getRoomByNr(Integer nr){return roomRepository.findById(nr);}

    public ResponseEntity<RoomEntity> deleteRoomByNr(Integer nr) {
        RoomEntity room = roomRepository.findById(nr).orElse(null);
        if(room != null){
            roomRepository.deleteById(nr);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<EntityModel<RoomEntity>> updateRoomByNr(Integer nr, RoomEntity newRoom){
        RoomEntity room = roomRepository.findById(nr).orElse(newRoom);
        if(newRoom.getNr()!=null&&
            newRoom.getPrice()!=null&&
            newRoom.getCapacity()!=null){
            room.setNr(newRoom.getNr());
            room.setPrice(newRoom.getPrice());
            room.setCapacity(newRoom.getCapacity());
            room.setFree(newRoom.getFree());
            EntityModel<RoomEntity> entityEntityModel = EntityModel.of(roomRepository.save(room));
            return new ResponseEntity<>(entityEntityModel,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

}

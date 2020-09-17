package com.example.Hotel.api;


import com.example.Hotel.Assemblers.RoomModelAssembler;
import com.example.Hotel.Entity.GuestEntity;
import com.example.Hotel.Entity.RoomEntity;
import com.example.Hotel.model.Room;
import com.example.Hotel.model.RoomModel;
import com.example.Hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/room")
@RestController
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @Autowired
    private PagedResourcesAssembler<RoomEntity> pagedResourcesAssembler;

    @Autowired
    private RoomModelAssembler roomModelAssembler;

    @PostMapping
    public void addRoom(@RequestBody RoomEntity room){roomService.addRoom(room);}

    @GetMapping
    public ResponseEntity<PagedModel<RoomModel>> getAllRooms(Pageable pageable){
        Page<RoomEntity> allRooms = roomService.getAllRooms(pageable);
        PagedModel<RoomModel> roomCollectionModel = pagedResourcesAssembler.toModel(allRooms,roomModelAssembler);
        return new ResponseEntity<>(roomCollectionModel, HttpStatus.OK);
    }

    @GetMapping(path="{nr}")
    public ResponseEntity<EntityModel<RoomEntity>> getRoomById(@PathVariable("nr") Integer nr){
        Link link = linkTo(RoomController.class).slash(nr).withSelfRel();
        Link linkAll = linkTo(RoomController.class).withRel("All Rooms");
        EntityModel<RoomEntity> roomEntityModel = EntityModel.of(roomService.getRoomByNr(nr).orElse(null));
        return new ResponseEntity<>(roomEntityModel,HttpStatus.OK);
    }

    @DeleteMapping(path="{nr}")
    public void deleteRoomByNr(@PathVariable("nr") Integer nr){roomService.deleteRoomByNr(nr);}

    @PutMapping(path="{nr}")
    public ResponseEntity<EntityModel<RoomEntity>> updateRoomById(@PathVariable("nr")Integer nr,@RequestBody RoomEntity roomToUpdate){
        return roomService.updateRoomByNr(nr,roomToUpdate);
    }


}

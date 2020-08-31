package com.example.Hotel.api;


import com.example.Hotel.model.Room;
import com.example.Hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/room")
@RestController
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){this.roomService=roomService;}

    @PostMapping
    public void addRoom(@Valid @NotNull @RequestBody Room room){roomService.addRoom(room);}

    @GetMapping
    public List<Room> getAllRooms(){return roomService.getAllRooms();}

    @GetMapping(path="{nr}")
    public Room getRoomById(@PathVariable("nr") int nr){
        return roomService.getRoomByNr(nr)
                .orElse(null);
    }

    @DeleteMapping(path="{nr}")
    public void deleteRoomByNr(@PathVariable("nr") int nr){roomService.deleteRoom(nr);}

    @PutMapping(path="{nr}")
    public void updateRoom(@PathVariable("nr") int nr,@Valid @NotNull @RequestBody Room roomToUpdate){
        roomService.updateRoom(nr,roomToUpdate);
    }


}

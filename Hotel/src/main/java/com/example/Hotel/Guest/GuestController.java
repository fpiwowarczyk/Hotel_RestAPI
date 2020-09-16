package com.example.Hotel.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/guest")
@RestController
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService){
        this.guestService = guestService;
    }

    @PostMapping
    public void addGuest(@Valid @NotNull @RequestBody Guest guest){
        guestService.addGuest(guest);
    }

    @GetMapping
    public List<Guest> getAllGuests(){
        return guestService.getAllGuests();
    }

    @GetMapping(path="{idCardNr}")
    public Guest getGuestById(@PathVariable("idCardNr") String idCardNr){
        return guestService.getGuestById(idCardNr)
                .orElse(null);
    }


    @DeleteMapping(path="{idCardNr}")
    public void deleteGuestById(@PathVariable("idCardNr") String idCardNr){
        guestService.deleteGuest(idCardNr);
    }

    @PutMapping(path = "{idCardNr}")
    public void updateGuest(@PathVariable("idCardNr") String idCardNr, @Valid @NotNull @RequestBody Guest guestToUpdate){
        guestService.updateGuest(idCardNr,guestToUpdate);
    }

    @PatchMapping(path="{idCardNr}")
    public void updateRoomGuest(@PathVariable("idCardNr")String idCardNr, @RequestBody GuestRoomChange room){
        guestService.updateRoomGuest(idCardNr,room);
    }

}

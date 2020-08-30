package com.example.Hotel.api;

import com.example.Hotel.model.Guest;
import com.example.Hotel.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

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

    @GetMapping(path="{id}")
    public Guest getGuestById(@PathVariable("id") UUID id){
        return guestService.getGuestById(id)
                .orElse(null);
    }


    @DeleteMapping(path="{id}")
    public void deleteGuestById(@PathVariable("id") UUID id){
        guestService.deleteGuest(id);
    }

    @PutMapping(path = "{id}")
    public void updateGuest(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Guest guestToUpdate){
        guestService.updateGuest(id,guestToUpdate);
    }
}

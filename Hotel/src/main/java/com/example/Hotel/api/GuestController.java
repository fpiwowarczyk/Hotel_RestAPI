package com.example.Hotel.api;

import com.example.Hotel.Assemblers.GuestModelAssembler;
import com.example.Hotel.Entity.GuestEntity;
import com.example.Hotel.model.GuestModel;
import com.example.Hotel.service.GuestService;
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


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/guest")
@RestController
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService){
        this.guestService = guestService;
    }

    @Autowired
    private PagedResourcesAssembler<GuestEntity> pagedResourcesAssembler;

    @Autowired
    private GuestModelAssembler guestModelAssembler;

    @PostMapping
    public void addGuest(@RequestBody GuestEntity guest){
        guestService.addGuest(guest);
    }

    @GetMapping
    public ResponseEntity<PagedModel<GuestModel>> getAllGuests(Pageable pageable){
        Page<GuestEntity> allGuest = guestService.getAllGuests(pageable);
        PagedModel<GuestModel> guestCollectionModel = pagedResourcesAssembler.toModel(allGuest,guestModelAssembler);
        return new ResponseEntity<>(guestCollectionModel, HttpStatus.OK);
    }

    @GetMapping(path="{idCardNr}")
    public ResponseEntity<EntityModel<GuestEntity>> getGuestById(@PathVariable("idCardNr") String idCardNr){
        Link link = linkTo(GuestController.class).slash(idCardNr).withSelfRel();
        Link linkAll = linkTo(GuestController.class).withRel("All Guests");
        EntityModel<GuestEntity> guestEntityModel = EntityModel.of(guestService.getGuestById(idCardNr).orElse(null));
        return new ResponseEntity<>(guestEntityModel,HttpStatus.OK);
    }


    @DeleteMapping(path="{idCardNr}")
    public void deleteGuestById(@PathVariable("idCardNr") String idCardNr){
        guestService.deleteGuestById(idCardNr);
    }

    @PutMapping(path = "{idCardNr}")
    public ResponseEntity<EntityModel<GuestEntity>> updateGuestById(@PathVariable("idCardNr") String idCardNr,@RequestBody GuestEntity guestToUpdate){
        return guestService.updateGuestById(idCardNr,guestToUpdate);
    }

    @PatchMapping(path = "{idCardNr}")
    public ResponseEntity<GuestEntity> updatePartialGuestById(@PathVariable("idCardNr") String idCardNr,@RequestBody GuestEntity guestToUpdate){
        return guestService.updatePartGuestById(idCardNr,guestToUpdate);
    }

}

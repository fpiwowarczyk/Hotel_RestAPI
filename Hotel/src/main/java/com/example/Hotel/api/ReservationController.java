package com.example.Hotel.api;


import com.example.Hotel.Assemblers.ReservationModelAssembler;
import com.example.Hotel.Entity.ReservationEntity;
import com.example.Hotel.model.ReservationModel;
import com.example.Hotel.service.ArchService;
import com.example.Hotel.service.ReservationService;
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

@RequestMapping("/reservation")
@RestController
public class ReservationController {

    private final ReservationService reservationService;


    @Autowired
    public ReservationController(ReservationService reservationService,ArchService archService) {
        this.reservationService = reservationService;
    }

    @Autowired
    private PagedResourcesAssembler pagedResourcesAssembler;

    @Autowired
    private ReservationModelAssembler reservationModelAssembler;

    @PostMapping
    public ResponseEntity<Link> addReservation(@RequestBody ReservationEntity reservation){ return reservationService.addReservation(reservation);}

    @GetMapping
    public ResponseEntity<PagedModel<ReservationModel>> getAllReservations(Pageable pageable) {
        Page<ReservationEntity> allReservations = reservationService.getAllReservations(pageable);
        PagedModel<ReservationModel> reservationCollectionModel = pagedResourcesAssembler.toModel(allReservations,reservationModelAssembler);
        return new ResponseEntity<>(reservationCollectionModel, HttpStatus.OK);
    }

    @GetMapping(path="{id}")
    public ResponseEntity<EntityModel<ReservationEntity>> getReservationById(@PathVariable("id") String id){
        Link link = linkTo(ReservationController.class).slash(id).withSelfRel();
        Link linkAll = linkTo(ReservationController.class).withRel("All Reservations");
        EntityModel<ReservationEntity> reservationEntityModel = EntityModel.of(reservationService.getReservationById(id).orElse(null),link,linkAll);
        return new ResponseEntity<>(reservationEntityModel,HttpStatus.OK);
    }

    @DeleteMapping(path="{id}")
    public void deleteReservationById(@PathVariable("id") String id){

        reservationService.deleteReservationById(id);
    }

    @PutMapping(path="{id}")
    public ResponseEntity<EntityModel<ReservationEntity>> updateReservationById(@PathVariable("id")String id,@RequestBody ReservationEntity reservationToUpdate){
        return reservationService.updateReservationById(id,reservationToUpdate);
    }


}

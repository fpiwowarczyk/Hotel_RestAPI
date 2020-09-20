package com.example.Hotel.api;


import com.example.Hotel.Assemblers.ArchModelAssembler;
import com.example.Hotel.Entity.ArchEntity;
import com.example.Hotel.model.ArchModel;
import com.example.Hotel.service.ArchService;
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

@RequestMapping("/arch")
@RestController
public class ArchController {

    private final ArchService archService;

    @Autowired
    public ArchController(ArchService archService) {
        this.archService = archService;
    }

    @Autowired
    private PagedResourcesAssembler pagedResourcesAssembler;

    @Autowired
    private ArchModelAssembler archModelAssembler;

    @GetMapping
    public ResponseEntity<PagedModel<ArchModel>> getAllArchs(Pageable pageable) {
        Page<ArchEntity> allArchs = archService.getAllArchs(pageable);
        PagedModel<ArchModel> archCollectionModel = pagedResourcesAssembler.toModel(allArchs, archModelAssembler);
        return new ResponseEntity<>(archCollectionModel, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EntityModel<ArchEntity>> getArchById(@PathVariable("id") String id) {
        Link link = linkTo(ArchController.class).slash(id).withSelfRel();
        Link linkAll = linkTo(ArchController.class).withRel("All archs");
        EntityModel<ArchEntity> archEntityModel = EntityModel.of(archService.getArchById(id).orElse(null),link,linkAll);
        return new ResponseEntity<>(archEntityModel, HttpStatus.OK);
    }
}
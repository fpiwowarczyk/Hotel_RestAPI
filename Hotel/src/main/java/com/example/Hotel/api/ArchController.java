package com.example.Hotel.api;


import com.example.Hotel.model.Arch;
import com.example.Hotel.service.ArchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("/arch")
@RestController
public class ArchController {
    private final ArchService archService;

    @Autowired
    public ArchController(ArchService archService){this.archService = archService;}

    @PostMapping
    public void addArch(@Valid @NotNull @RequestBody Arch arch){archService.addArch(arch);}

    @GetMapping
    public List<Arch> getAllArch(){return archService.getAllArch();}

    @GetMapping(path="{id}")
    public Arch getArchById(@PathVariable("id") UUID id){
        return archService.getArchById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deleteArchById(@PathVariable("id") UUID id){archService.deleteArch(id);}

    @PutMapping(path="{id}")
    public void updateArch(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Arch archToUpdate){

        archService.updateArchById(id,archToUpdate);
    }


}

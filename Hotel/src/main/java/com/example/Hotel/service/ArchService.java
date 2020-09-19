package com.example.Hotel.service;


import com.example.Hotel.Entity.ArchEntity;
import com.example.Hotel.dao.ArchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArchService {

    @Autowired
    private ArchRepository archRepository;


    public ArchEntity addArch(ArchEntity arch) {
        arch.setId(UUID.randomUUID().toString());
        return archRepository.save(arch);
    }

    public Page<ArchEntity> getAllArchs(Pageable pageable) {
        return archRepository.findAll(pageable);
    }

    public Optional<ArchEntity> getArchById(String id) {
        return archRepository.findById(id);
    }
}
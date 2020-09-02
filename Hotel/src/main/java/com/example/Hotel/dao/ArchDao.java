package com.example.Hotel.dao;

import com.example.Hotel.model.Arch;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArchDao {
    int insertArch(Arch arch);

    List<Arch> selectAllArch();

    Optional<Arch> selectArchById(UUID id);

}

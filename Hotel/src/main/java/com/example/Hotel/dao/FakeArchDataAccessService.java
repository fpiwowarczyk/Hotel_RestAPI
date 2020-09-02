package com.example.Hotel.dao;


import com.example.Hotel.model.Arch;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeArchDao")
public class FakeArchDataAccessService implements ArchDao {

    public static List<Arch> DB = new ArrayList<>();

    @Override
    public int insertArch(Arch arch) {
        DB.add(new Arch(arch.getId(),arch.getStart(),arch.getEnd(),arch.getRoomMates(),arch.getReason()));
        return 1;
    }

    @Override
    public List<Arch> selectAllArch() {
        return DB;
    }

    @Override
    public Optional<Arch> selectArchById(UUID id) {
       return DB.stream()
               .filter(arch -> arch.getId().equals(id))
               .findFirst();
    }




}

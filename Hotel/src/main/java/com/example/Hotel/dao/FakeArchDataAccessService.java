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

    @Override
    public int deleteArchById(UUID id) {
        Optional<Arch> archMaybe = selectArchById(id);
        if(archMaybe.isEmpty())
            return 0;
        DB.remove(archMaybe.get());
        return 1;
    }

    @Override
    public int updateArchById(UUID id, Arch update) {
        return selectArchById(id)
                .map(arch -> {
                    int indexOfArchToUpdate = DB.indexOf(arch);
                    if(indexOfArchToUpdate >= 0){
                        DB.set(indexOfArchToUpdate, new Arch(update.getId(),update.getStart(),update.getEnd(),update.getRoomMates(),update.getReason()));
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .orElse(0);
    }
}

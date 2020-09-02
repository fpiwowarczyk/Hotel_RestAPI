package com.example.Hotel.service;


import com.example.Hotel.dao.ArchDao;
import com.example.Hotel.model.Arch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArchService {

    public final ArchDao archDao;

    @Autowired
    public ArchService(@Qualifier("fakeArchDao")ArchDao archDao){this.archDao = archDao;}

    public int addArch(Arch arch) {return archDao.insertArch(arch);}

    public List<Arch> getAllArch(){return archDao.selectAllArch();}

    public Optional<Arch> getArchById(UUID id){return archDao.selectArchById(id);}

    public int deleteArch(UUID id){return archDao.deleteArchById(id);}

    public int updateArchById(UUID id,Arch newArch){return archDao.updateArchById(id,newArch);}

}

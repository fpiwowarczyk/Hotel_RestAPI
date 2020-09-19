package com.example.Hotel.dao;

import com.example.Hotel.Entity.ArchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArchRepository extends JpaRepository<ArchEntity, String>, PagingAndSortingRepository<ArchEntity,String > {
}

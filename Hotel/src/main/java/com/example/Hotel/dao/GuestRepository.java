package com.example.Hotel.dao;

import com.example.Hotel.Entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity,String>, PagingAndSortingRepository<GuestEntity,String > {
}

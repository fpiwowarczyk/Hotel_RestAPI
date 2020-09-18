package com.example.Hotel.dao;

import com.example.Hotel.Entity.GuestEntity;
import com.example.Hotel.Entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, String>, PagingAndSortingRepository<ReservationEntity,String > {
}

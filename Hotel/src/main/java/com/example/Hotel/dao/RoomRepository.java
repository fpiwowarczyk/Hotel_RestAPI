package com.example.Hotel.dao;


import com.example.Hotel.Entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,Integer>, PagingAndSortingRepository<RoomEntity,Integer> {
}

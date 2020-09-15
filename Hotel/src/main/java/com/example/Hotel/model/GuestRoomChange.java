package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GuestRoomChange {
    private final Integer room;

    public GuestRoomChange(
                 @JsonProperty("room") Integer room){
        this.room  = room;
    }

    public Integer getNr(){return room;}
}

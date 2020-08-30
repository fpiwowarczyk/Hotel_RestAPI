package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Room {
    @NotBlank
    private final Integer nr;
    @NotBlank
    private final int price;
    private int capacity;
    private Boolean free;

    public Room(@JsonProperty("nr") Integer nr,
                @JsonProperty("price") int price,
                @JsonProperty("capacity") int capacity,
                @JsonProperty("free") Boolean free){
        this.nr = nr;
        this.price = price;
        this.capacity=capacity;
        this.free=free;
    }

    public Integer getNr(){return nr;}

    public int getPrice(){return price;}

    public int getCapacity(){return capacity;}

    public Boolean getFree(){return free;}
}

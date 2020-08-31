package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Reservation {
    @NotBlank
    private final UUID id;
    private final String start;
    private final String end;
    private String guest;

    public Reservation(@JsonProperty("id") UUID id,
                       @JsonProperty("start") String start,
                       @JsonProperty("end") String end,
                       @JsonProperty("guest") String guest){
        this.id = id;
        this.start = start;
        this.end = end;
        this.guest = guest;
    }

    public UUID getId(){return id;}

    public String getStart(){return start;}

    public String getEnd(){return end;}

    public String getRoomMates(){return guest;}
}

package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

public class Reservation {
    @NotBlank
    private final UUID id;
    @NotBlank
    private final String start;
    private final String end;
    private List<Guest> roomMates;

    public Reservation(@JsonProperty("id") UUID id,
                       @JsonProperty("start") String start,
                       @JsonProperty("end") String end,
                       @JsonProperty("roomMates") List<Guest> roomMates){
        this.id = id;
        this.start = start;
        this.end = end;
        this.roomMates = roomMates;
    }

    public UUID getId(){return id;}

    public String getStart(){return start;}

    public String getEnd(){return end;}

    public List<Guest> getRoomMates(){return roomMates;}
}

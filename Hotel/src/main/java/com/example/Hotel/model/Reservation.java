package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    @NotBlank
    private final UUID id;
    private final LocalDate start;
    private final LocalDate end;
    private String guest;

    public Reservation(@JsonProperty("id") UUID id,
                       @JsonProperty("start") LocalDate start, //YYYY-MM-DD
                       @JsonProperty("end") LocalDate end,//YYYY-MM-DD
                       @JsonProperty("guest") String guest){
        this.id = id;
        this.start = start;
        this.end = end;
        this.guest = guest;
    }

    public UUID getId(){return id;}

    public LocalDate getStart(){return start;}

    public LocalDate getEnd(){return end;}

    public String getRoomMates(){return guest;}
}

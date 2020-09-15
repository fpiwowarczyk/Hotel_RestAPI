package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ReservationDatesChange {
    private final LocalDate start;
    private final LocalDate end;

    public ReservationDatesChange(@JsonProperty("start") LocalDate start,
                                  @JsonProperty("end") LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart(){return start;}

    public LocalDate getEnd(){return end;}
}

package com.example.Hotel.model;

import java.time.LocalDate;
import java.util.UUID;

public class Arch {
    private final UUID id;
    private final LocalDate start;
    private final LocalDate end;
    private String guest;
    private String reason;

    public Arch(UUID id,
                LocalDate start,
                LocalDate end,
                String guest,
                String reason){
        this.id = id;
        this.start = start;
        this.end = end;
        this.guest  = guest;
        this.reason = reason;
    }

    public UUID getId(){return id;}

    public LocalDate getStart(){return start;}

    public LocalDate getEnd(){return end;}

    public String getRoomMates(){return guest;}

    public String getReason(){return reason;}
}

package com.example.Hotel.model;

import java.util.UUID;

public class Arch {
    private final UUID id;
    private final String start;
    private final String end;
    private String guest;
    private String reason;

    public Arch(UUID id,
                String start,
                String end,
                String guest,
                String reason){
        this.id = id;
        this.start = start;
        this.end = end;
        this.guest  = guest;
        this.reason = reason;
    }

    public UUID getId(){return id;}

    public String getStart(){return start;}

    public String getEnd(){return end;}

    public String getRoomMates(){return guest;}

    public String getReason(){return reason;}
}

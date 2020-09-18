package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Arch {

    private final UUID id;
    @NotBlank
    private final String start;
    @NotBlank
    private final String end;
    private String guestIdCardNr;

    public Arch(@JsonProperty("id") UUID id,
                       @JsonProperty("start") String start, //YYYY-MM-DD
                       @JsonProperty("end") String end,//YYYY-MM-DD
                       @JsonProperty("guest") String guestIdCardNr){
        this.id = id;
        this.start = start;
        this.end = end;
        this.guestIdCardNr= guestIdCardNr;
    }

    public UUID getId(){return id;}

    public String getStart(){return start;}

    public String getEnd(){return end;}

    public String guestIdCardNr(){return guestIdCardNr;}
}

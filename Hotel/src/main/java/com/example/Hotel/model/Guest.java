package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Guest {
    private final String idCardNr;
    @NotBlank
    private final String name;
    @NotBlank
    private final String surname;

    private final Integer room;

    public Guest(@JsonProperty("idCardNr") String idCardNr,
                 @JsonProperty("name") String name,
                 @JsonProperty("surname") String surname,
                 @JsonProperty("room") Integer room){
        this.idCardNr = idCardNr;
        this.name = name;
        this.surname = surname;
        this.room  = room;
    }


    public String getIdCardNr(){return idCardNr;}

    public String getName(){return name;}

    public String getSurname(){return surname;}

    public Integer getRoom(){return room;}
}

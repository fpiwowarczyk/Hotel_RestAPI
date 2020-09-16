package com.example.Hotel.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;

public class Guest extends RepresentationModel<Guest> {
    @NotBlank
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

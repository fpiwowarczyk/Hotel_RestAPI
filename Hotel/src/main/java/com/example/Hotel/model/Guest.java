package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Guest {
    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String surname;

    public Guest(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name,
                 @JsonProperty("surname") String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }


    public UUID getId(){return id;}

    public String getName(){return name;}

    public String getSurname(){return surname;}
}

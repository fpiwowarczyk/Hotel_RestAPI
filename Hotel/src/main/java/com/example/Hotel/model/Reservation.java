package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Reservation {
    private final UUID id;
    @NotBlank
    private final String start_of;
    @NotBlank
    private final String end_of;
    private String guest_id_card_nr;

    public Reservation(@JsonProperty("id") UUID id,
                       @JsonProperty("start_of") String start_of, //YYYY-MM-DD
                       @JsonProperty("end_of") String end_of,//YYYY-MM-DD
                       @JsonProperty("guest_id_card_nr") String guest_id_card_nr){
        this.id = id;
        this.start_of = start_of;
        this.end_of = end_of;
        this.guest_id_card_nr= guest_id_card_nr;
    }

    public UUID getId(){return id;}

    public String getStart_of(){return start_of;}

    public String getEnd_of(){return end_of;}

    public String getGuest_Id_Card_Nr(){return guest_id_card_nr;}
}

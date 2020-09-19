package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArchModel extends RepresentationModel<ArchModel> {
    private String id;

    private String start_of;

    private String end_of;

    private String guest_id_card_nr;

    public void setId(String id){this.id = id;}

    public void setStart_of(String start_of){this.start_of = start_of;}

    public void setEnd_of(String end_of){this.end_of = end_of;}

    public void setGuestIdCardNr(String guest_id_card_nr){
        this.guest_id_card_nr = guest_id_card_nr;
    }

    public String getId(){return id;}

    public String getStart_of(){return start_of;}

    public String getEnd_of(){return end_of;}

    public String getGuest_Id_Card_Nr(){return guest_id_card_nr;}
}

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

    private UUID id;

    private String start;

    private String end;

    private String guestIdCardNr;

    public void setId(UUID id){this.id = id;}

    public void setStart(String start){this.start = start;}

    public void setEnd(String end){this.end = end;}

    public void setGuestIdCardNr(String guestIdCardNr){
        this.guestIdCardNr = guestIdCardNr;
    }

    public UUID getId(){return id;}

    public String getStart(){return start;}

    public String getEnd(){return end;}

    public String getGuestIdCardNr(){return guestIdCardNr;}
}

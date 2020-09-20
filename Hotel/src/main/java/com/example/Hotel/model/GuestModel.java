package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuestModel extends RepresentationModel<GuestModel> {
    private String idCardNr;

    private String name;

    private String surname;

    private Integer room;


    public void setIdCardNr(String idCardNr){
        this.idCardNr = idCardNr;
    }

    public void setName(String name){
        this.name= name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setRoom(Integer room){
        this.room = room;
    }


    public String getIdCardNr(){
        return idCardNr;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public Integer getRoom(){
        return room;
    }
}

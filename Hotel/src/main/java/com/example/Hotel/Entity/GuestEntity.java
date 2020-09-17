package com.example.Hotel.Entity;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guest")

public class GuestEntity extends RepresentationModel<GuestEntity> {

    @Id
    @Column(name = "idCardNr")
    private String idCardNr;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private Integer room;

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

    public void setIdCardNr(String idCardNr){
        this.idCardNr = idCardNr;
    }

    public void setName(String name){
        this.name =  name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setRoom(Integer room){
        this.room = room;
    }
}

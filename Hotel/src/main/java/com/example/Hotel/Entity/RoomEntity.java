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
@Table(name= "room")

public class RoomEntity extends RepresentationModel<RoomEntity> {

    @Id
    @Column(name = "nr")
    private Integer nr;

    private Integer price;

    private Integer capacity;

    private Boolean free;

    public Integer getNr(){ return nr;}

    public Integer getPrice(){return price;}

    public Integer getCapacity(){ return capacity;}

    public Boolean getFree(){return free;}


    public void setNr(Integer nr){
        this.nr = nr;
    }

    public void setPrice(Integer price){
        this.price = price;
    }

    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

    public void setFree(Boolean free){
        this.free = free;
    }

}

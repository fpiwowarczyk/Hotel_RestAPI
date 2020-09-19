package com.example.Hotel.Entity;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

}

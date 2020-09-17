package com.example.Hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomModel extends RepresentationModel<RoomModel> {
    private Integer nr;

    private Integer price;

    private Integer capacity;

    private Boolean free;

    public void setNr(Integer nr) { this.nr = nr;}

    public void setPrice(Integer price) { this.price = price;}

    public void setCapacity(Integer capacity){this.capacity = capacity;}

    public void setFree(Boolean free){this.free =free;}

    public Integer getNr(){return nr;}

    public Integer getPrice(){return price;}

    public Integer getCapacity(){return capacity;}

    public Boolean getFree(){return free;}



}

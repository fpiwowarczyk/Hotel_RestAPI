package com.example.Hotel.Entity;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "arch_reservation")
public class ArchEntity extends RepresentationModel<ArchEntity> {

    @Id
    @Column(name = "id")
    private String id;

    @NotBlank
    private String start_of;

    @NotBlank
    private String end_of;

    private String guest_id_card_nr;

    public String getId() {
        return id;
    }

    public String getStart_of() {
        return start_of;
    }

    public String getEnd_of() {
        return end_of;
    }

    public String getGuest_Id_Card_Nr() {
        return guest_id_card_nr;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStart_of(String start_of) {
        this.start_of = start_of;
    }

    public void setEnd_of(String end_of) {
        this.end_of = end_of;
    }

    public void setGuest_Id_Card_Nr(String guest_id_card_nr) {
        this.guest_id_card_nr = guest_id_card_nr;
    }
}



package ng.com.bitsystems.slowcodepetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Visits")
public class Visit extends BaseEntity{

    @Column(name = "visit_date")
    private LocalDate localDate;

    private String description;

    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private Pet pet;

}

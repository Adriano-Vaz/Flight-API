package fr.unilasalle.flight.api.beans;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@Getter
@Setter
public class Reservations extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "reservations_sequence_in_java_code",
            sequenceName = "reservations_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservations_sequence_in_java_code")
    private Integer id;

    @Column(nullable = false)
    private Integer flight_id;

    @Column(nullable = false)
    private Integer passenger_id;
}

package fr.unilasalle.flight.api.beans;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "planes")
@NoArgsConstructor
@Getter
@Setter
public class Planes extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "planes_sequence_in_java_code",
            sequenceName = "planes_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planes_sequence_in_java_code")
    private Integer id;

    @Column(nullable = false)
    private String operator;

    @Column(nullable = false)
    private String model;

    @Column(unique = true, nullable = false)
    private String registration;

    @Column(nullable = false)
    private Integer capacity;

}

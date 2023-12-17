package fr.unilasalle.flight.api.beans;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passengers")
@NoArgsConstructor
@Getter
@Setter
public class Passengers extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "passengers_sequence_in_java_code",
            sequenceName = "passengers_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengers_sequence_in_java_code")
    private Integer id;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

}

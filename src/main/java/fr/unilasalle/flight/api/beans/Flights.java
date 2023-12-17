package fr.unilasalle.flight.api.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flights")
@NoArgsConstructor
@Getter
@Setter
public class Flights {
    @Id
    @SequenceGenerator(
            name = "flights_sequence_in_java_code",
            sequenceName = "flights_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flights_sequence_in_java_code")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String departure_date;

    @Column(nullable = false)
    private String departure_time;

    @Column(nullable = false)
    private String arrival_date;

    @Column(nullable = false)
    private String arrival_time;

    @Column(nullable = false)
    private Integer plane_id;
}

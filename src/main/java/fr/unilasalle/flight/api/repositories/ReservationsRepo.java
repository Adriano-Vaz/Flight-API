package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Passengers;
import fr.unilasalle.flight.api.beans.Reservations;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;

@Model
public class ReservationsRepo implements PanacheRepositoryBase<Reservations, Integer> {

}
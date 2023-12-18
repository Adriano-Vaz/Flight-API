package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Passengers;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;

import java.util.List;

@Model
public class PassengersRepo implements PanacheRepositoryBase<Passengers, Integer> {
        public Passengers findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
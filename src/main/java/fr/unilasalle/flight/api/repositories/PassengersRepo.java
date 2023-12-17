package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Passengers;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;

import java.util.List;

@Model
public class PassengersRepo implements PanacheRepositoryBase<Passengers, Long> {
    public List<Passengers> findBySurname(String surname) {
        return list("surname", surname);
    }

    public List<Passengers> findByName(String name) {
        return list("name", name);
    }

    public List<Passengers> findByEmail(String email) {
        return list("email", email);
    }
}
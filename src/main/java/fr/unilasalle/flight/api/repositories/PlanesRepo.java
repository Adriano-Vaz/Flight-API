package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Planes;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;

import java.util.List;

@Model
public class PlanesRepo implements PanacheRepositoryBase<Planes, Long> {
    public List<Planes> findByModel(String model) {
        return list("model", model);
    }

    public List<Planes> findByRegistration(String registration) {
        return list("registration", registration);
    }
}
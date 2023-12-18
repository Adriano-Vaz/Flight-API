package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Flights;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;
import org.h2.api.DatabaseEventListener;

import java.sql.Time;
import java.util.Date;

@Model
public class FlightsRepo implements PanacheRepositoryBase<Flights, Integer> {
    public Flights findByNumber(String number){
        return find("number", number).firstResult();
    }
    public Flights findByDestination(String destination){
        return find("destination", destination).firstResult();
    }
}

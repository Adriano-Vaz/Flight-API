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
    public Flights findByOrigin(String origin){
        return find("origin", origin).firstResult();
    }
    public Flights findByDestination(String destination){
        return find("destination", destination).firstResult();
    }
    public Flights findByDepartureDate(Date departure_date){
        return find("departure_date", departure_date).firstResult();
    }
    public Flights findByDepartureTime(Time departure_time){
        return find("departure_time", departure_time).firstResult();
    }
    public Flights findByArrivalDate(Date arrival_date){
        return find("arrival_date", arrival_date).firstResult();
    }
    public Flights findByArrivalTime(Time arrival_time){
        return find("arrival_time", arrival_time).firstResult();
    }
    public Flights findByPlane(Integer plane_id){
        return find("plane_id", plane_id).firstResult();
    }
}

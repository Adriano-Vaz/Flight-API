package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Flights;
import fr.unilasalle.flight.api.repositories.FlightsRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/flights")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightResources extends GenericResource {
    @Inject
    FlightsRepo flightRepository;

    @GET
    public Response listAllFlights() {
        List<Flights> flights = flightRepository.listAll();
        return getOr404(flights);
    }

    @GET
    @Path("/dest/{destination}")
    public Response getFlightByDestination(@PathParam("destination") String destination) {
        Flights flight = flightRepository.findByDestination(destination);
        return getOr404(flight);
    }

    @GET
    @Path("/number/{number}")
    public Response getFlightByNumber(@PathParam("number") String number) {
        Flights flight = flightRepository.findByNumber(number);
        return getOr404(flight);
    }

    @POST
    @Transactional
    public Response createFlight(Flights flight) {
        flightRepository.persist(flight);
        return Response.status(Response.Status.CREATED).entity(flight).build();
    }

    @DELETE
    @Transactional
    @Path("/number/{number}")
    public Response deleteFlight(@PathParam("number") String number) {
        Flights existingFlight = flightRepository.findByNumber(number);
        if (existingFlight == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        flightRepository.delete(existingFlight);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

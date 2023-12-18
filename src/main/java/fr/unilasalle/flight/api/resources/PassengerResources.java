package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Flights;
import fr.unilasalle.flight.api.beans.Passengers;
import fr.unilasalle.flight.api.repositories.PassengersRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/passengers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PassengerResources extends GenericResource {
    @Inject
    PassengersRepo passengerRepository;

    @GET
    public Response listAllPassengers() {
        List<Passengers> passenger = passengerRepository.listAll();
        return getOr404(passenger);
    }

    @GET
    @Path("/{email}")
    public Response getPassengerById(@PathParam("email") String email) {
        Passengers passenger = passengerRepository.findByEmail(email);
        return getOr404(passenger);
    }

    @POST
    @Transactional
    public Response createPassenger(Passengers passenger) {
        passengerRepository.persist(passenger);
        return Response.status(Response.Status.CREATED).entity(passenger).build();
    }

    @DELETE
    @Transactional
    @Path("/{email}")
    public Response deletePassenger(@PathParam("email") String email) {
        Passengers existingPassenger = passengerRepository.findByEmail(email);
        if (existingPassenger == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        passengerRepository.delete(existingPassenger);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

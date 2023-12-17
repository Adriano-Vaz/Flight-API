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
    @Path("/{id}")
    public Response getPassengerById(@PathParam("id") Integer id) {
        Passengers passenger = passengerRepository.findById(Long.valueOf(id));
        return getOr404(passenger);
    }

    @POST
    @Transactional
    public Response createPassenger(Passengers passenger) {
        passengerRepository.persist(passenger);
        return Response.status(Response.Status.CREATED).entity(passenger).build();
    }

   /* @PUT
    @Path("/{id}")
    public Response updateFlight(@PathParam("id") Integer id, Flights flight) {
        Flights existingFlight = flightRepository.findById(id);
        if (existingFlight == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // Vous devriez ajouter la logique pour mettre à jour les champs de l'entité ici
        if(flightRepository.origin.findById(id) = NULL){

        }

        flightRepository.persist(existingFlight);
        return Response.ok(existingFlight).build();
    }*/

    /* public Response updatePassenger(Passenger passenger) {
        // check which fields are filled and retrieve fields not filled from db
        Passenger passengerFromDb = passengerRepo.findById(passenger.getId());
        if (passenger.getFirstname() == null) {
            passenger.setFirstname(passengerFromDb.getFirstname());
        }
        if (passenger.getLastname() == null) {
            passenger.setLastname(passengerFromDb.getLastname());
        }
        if (passenger.getEmail() == null) {
            passenger.setEmail(passengerFromDb.getEmail());
        }

        passengerRepo.update("firstname = ?1, lastname = ?2, email = ?3",
                passenger.getFirstname(), passenger.getLastname(), passenger.getEmail());
        return Response.ok(passenger).status(200).build();
    }*/

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletePassenger(@PathParam("id") Integer id) {
        Passengers existingPassenger = passengerRepository.findById(Long.valueOf(id));
        if (existingPassenger == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        passengerRepository.delete(existingPassenger);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

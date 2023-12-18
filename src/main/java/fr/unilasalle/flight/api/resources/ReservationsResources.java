package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Flights;
import fr.unilasalle.flight.api.beans.Passengers;
import fr.unilasalle.flight.api.beans.Reservations;
import fr.unilasalle.flight.api.repositories.PassengersRepo;
import fr.unilasalle.flight.api.repositories.ReservationsRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationsResources extends GenericResource {
    @Inject
    ReservationsRepo reservationRepository;

    @GET
    public Response listAllReservations() {
        List<Reservations> reservation = reservationRepository.listAll();
        return getOr404(reservation);
    }

    @GET
    @Path("/{id}")
    public Response getReservationById(@PathParam("id") Integer id) {
        Reservations reservation = reservationRepository.findById(id);
        return getOr404(reservation);
    }

    @POST
    @Transactional
    public Response createReservations(Reservations reservation) {
        reservationRepository.persist(reservation);
        return Response.status(Response.Status.CREATED).entity(reservation).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletePassenger(@PathParam("id") Integer id) {
        Reservations existingReservation = reservationRepository.findById(id);
        if (existingReservation == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        reservationRepository.delete(existingReservation);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

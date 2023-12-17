package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Planes;
import fr.unilasalle.flight.api.repositories.PlanesRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/planes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlaneResources extends GenericResource {
    @Inject
    PlanesRepo planeRepository;

    @GET
    public Response listAllPlanes() {
        List<Planes> plane = planeRepository.listAll();
        return getOr404(plane);
    }

    @GET
    public Response getPlaneByModel(@QueryParam("model") String model) {
        List<Planes> plane = planeRepository.findByModel(model);
        return getOr404(plane);
    }

    @GET
    @Path("/{registration}")
    public Response getPlaneByRegistration(@PathParam("registration") String registration) {
        List<Planes> plane = planeRepository.findByRegistration(registration);
        return getOr404(plane);
    }

    @POST
    @Transactional
    public Response createPlane(Planes plane) {
        planeRepository.persist(plane);
        return Response.status(Response.Status.CREATED).entity(plane).build();
    }

    @DELETE
    @Transactional
    @Path("/{registration}")
    public Response deletePlane(@PathParam("registration") String registration) {
        Planes existingPlane = planeRepository.findById(Long.valueOf(registration));
        if (existingPlane == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        planeRepository.delete(existingPlane);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

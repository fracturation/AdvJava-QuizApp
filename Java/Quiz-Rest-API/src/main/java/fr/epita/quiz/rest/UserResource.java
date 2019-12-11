package fr.epita.quiz.rest;

import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/users/")
public class UserResource {

    @Inject
    UserDAO dao;

    private static final Logger LOGGER = LogManager.getLogger(UserResource.class);


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(@RequestBody User user) throws URISyntaxException {

        dao.insert(user);
        LOGGER.info("received creation order for user : id " +  user.getId() + " ; name " + user.getName());
        return Response.created(new URI("users/" + String.valueOf(user.getId()))).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentById(@PathParam("id") int id) {

        User user = dao.getById(id, User.class);

        return Response.ok(user).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchStudents(@QueryParam("uName") String userName) {

        List<User> searchList = dao.search(new User(userName, ""));
        LOGGER.info("received search request for search term " +  userName + " : results returned = " + searchList.size());
        return Response.ok(searchList).build();
    }
}

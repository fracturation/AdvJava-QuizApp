package fr.epita.quiz.rest;


import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.AuthDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/auth/")
public class AuthResource {

    @Inject
    AuthDAO dao;

    private static final Logger LOGGER = LogManager.getLogger(AuthResource.class);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@RequestBody User user) {
        List<User> userList = dao.search(user);
        LOGGER.info("received login request for user name " + user.getName());
        if(userList.size() > 0) {
            User authUser = userList.get(0);
            authUser.setAuthToken("jwt-token-" + user.getId());
            return Response.ok(authUser).build();
        }
        return Response.status(400, "Username and/or password is incorrect").build();
    }
}

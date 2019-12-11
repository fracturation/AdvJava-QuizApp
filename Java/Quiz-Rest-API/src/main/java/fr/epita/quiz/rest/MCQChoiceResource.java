package fr.epita.quiz.rest;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.services.MCQChoiceDAO;
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

@Path("/mcqchoice/")
public class MCQChoiceResource {

    @Inject
    MCQChoiceDAO dao;

    private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMCQChoice(@RequestBody MCQChoice mcqChoice) throws URISyntaxException {

        dao.insert(mcqChoice);
        //LOGGER.info("received creation order for mcqChoice : " +  mcqChoice);
        return Response.created(new URI("mcqchoice/" + String.valueOf(mcqChoice.getId()))).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMCQChoiceById(@PathParam("id") int id) {

        MCQChoice mcqChoice = dao.getById(id, MCQChoice.class);

        return Response.ok(mcqChoice).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchMCQChoices(@QueryParam("cContent") String choiceContent) {

        List<MCQChoice> searchList = dao.search(new MCQChoice(choiceContent));

        return Response.ok(searchList).build();
    }
}

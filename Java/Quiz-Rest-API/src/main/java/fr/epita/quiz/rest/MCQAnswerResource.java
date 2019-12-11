package fr.epita.quiz.rest;

import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.services.MCQAnswerDAO;
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

@Path("/mcqanswers/")
public class MCQAnswerResource {

    @Inject
    MCQAnswerDAO dao;

    private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMCQAnswer(@RequestBody MCQAnswer mcqAnswer) throws URISyntaxException {

        dao.insert(mcqAnswer);
        //LOGGER.info("received creation order for mcqAnswer : " +  mcqAnswer);
        return Response.created(new URI("mcqanswer/" + String.valueOf(mcqAnswer.getId()))).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMCQAnswerById(@PathParam("id") int id) {

        MCQAnswer mcqAnswer = dao.getById(id, MCQAnswer.class);

        return Response.ok(mcqAnswer).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchMCQAnswers(@QueryParam("aContent") String choiceContent) {

        List<MCQAnswer> searchList = dao.search(new MCQAnswer()); //????????????????

        return Response.ok(searchList).build();
    }
}

package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@Path("/questions/")
//this class is for path mapping
public class QuestionResource {

    @Inject
    QuestionDAO dao;

    private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createQuestion(@RequestBody Question question) throws URISyntaxException {

        dao.insert(question);
        LOGGER.info("received creation order for question : " +  question);
        return Response.created(new URI("questions/" + String.valueOf(question.getId()))).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestionById(@PathParam("id") int id) {

        Question question = dao.getById(id, Question.class);

        return Response.ok(question).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchQuestions(@QueryParam("qContent") String questionContent) {

        List<Question> searchList = dao.search(new Question(questionContent));

        return Response.ok(searchList).build();
    }
}

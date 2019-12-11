package fr.epita.quiz.rest;


import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionToChoiceDAO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/q2mcq/")
public class QuestionToChoiceResource {

    @Inject
    QuestionToChoiceDAO dao;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchMCQChoices(@RequestBody Question question) {

        Integer id = question.getId();

        List<MCQChoice> searchList = dao.search(new MCQChoice(id.toString()));

        return Response.ok(searchList).build();
    }
}

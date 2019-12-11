package fr.epita.quiz.rest;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.services.ExamDAO;
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

@Path("/exams/")
public class ExamResource {

    @Inject
    ExamDAO dao;

    private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createExam(@RequestBody Exam exam) throws URISyntaxException {

        dao.insert(exam);
        LOGGER.info("received creation order for exam : id " +  exam.getId() + " ; title " + exam.getTitle());
        return Response.created(new URI("exams/" + String.valueOf(exam.getId()))).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExamById(@PathParam("id") int id) {

        Exam exam = dao.getById(id, Exam.class);

        return Response.ok(exam).build();
    }

//    @POST
//    @Path("/upd")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateExam(@RequestBody Exam exam) throws URISyntaxException {
//
//        dao.update(exam);
//        LOGGER.info("received update order for exam : id " +  exam.getId() + " ; title " + exam.getTitle());
//        return Response.created(new URI("exams/" + String.valueOf(exam.getId()))).build();
//    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchExams(@QueryParam("eTitle") String examTitle) {

        List<Exam> searchList = dao.search(new Exam(examTitle));
        LOGGER.info("received search request for search term " +  examTitle + " : results returned = " + searchList.size());
        return Response.ok(searchList).build();
    }
}

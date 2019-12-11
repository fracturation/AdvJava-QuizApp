package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.MCQAnswer;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MCQAnswerDAO extends DAO<MCQAnswer> {

    @Override
    public String getQueryString() {
        return "from MCQAnswer a where a.student_id = :aStudent and a.exam_id = :aExam";
    } //get a list of all the answers for a specific student for a specific exam
    //or maybe get the answers for each question and mark as time goes on.

    @Override
    public void fillParametersMap(Map<String, Object> map, MCQAnswer answer) {
        map.put("aStudent", answer.getUser());
        map.put("aExam", answer.getExam());
    }
}

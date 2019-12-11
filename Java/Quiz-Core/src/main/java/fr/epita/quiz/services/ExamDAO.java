package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.Exam;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ExamDAO extends DAO<Exam> {

    @Override
    public String getQueryString() {
        return "from Exam e where e.title like :eTitle";
    }

    @Override
    public void fillParametersMap(Map<String, Object> map, Exam exam) {
        map.put("eTitle", String.format("%%%s%%", exam.getTitle()));
    }
}

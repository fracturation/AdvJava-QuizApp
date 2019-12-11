package fr.epita.quiz.services;


import fr.epita.quiz.datamodel.Question;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class QuestionDAO extends DAO<Question>{


    @Override
    public String getQueryString() {
        return "from Question q where q.questionContent like :pContent";
    }

    @Override
    public void fillParametersMap(Map<String, Object> map, Question question) {
        map.put("pContent", String.format("%%%s%%", question.getContent()));
    }
}

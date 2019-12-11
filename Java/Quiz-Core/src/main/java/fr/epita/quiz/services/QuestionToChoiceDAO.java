package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.MCQChoice;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class QuestionToChoiceDAO extends DAO<MCQChoice> {

    @Override
    public String getQueryString() {
        return "from MCQChoice where question_id = :qID";
    }

    @Override
    public void fillParametersMap(Map<String, Object> map, MCQChoice choice) {
        map.put("qID", choice.getChoice());
    }
}

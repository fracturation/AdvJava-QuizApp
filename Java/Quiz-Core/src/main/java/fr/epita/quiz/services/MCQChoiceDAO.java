package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.MCQChoice;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MCQChoiceDAO extends DAO<MCQChoice> {

    @Override
    public String getQueryString() {
        return "from MCQChoice c where c.choice like :cContent";
    }

    @Override
    public void fillParametersMap(Map<String, Object> map, MCQChoice mcqChoice) {
        map.put("cContent", String.format("%%%s%%", mcqChoice.getChoice()));
    }
}

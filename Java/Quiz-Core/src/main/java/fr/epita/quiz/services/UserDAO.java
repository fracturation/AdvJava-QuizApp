package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDAO extends DAO<User> {

    @Override
    public String getQueryString() {
        return "from User u where u.name like :uName";
    }

    @Override
    public void fillParametersMap(Map<String, Object> map, User user) {
        map.put("uName", user.getName());
    }
}

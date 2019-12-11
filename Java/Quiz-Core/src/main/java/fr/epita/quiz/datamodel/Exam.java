package fr.epita.quiz.datamodel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EXAM")
public class Exam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @OneToMany(targetEntity=Question.class, fetch = FetchType.EAGER)
    private List<Question> questions = new ArrayList<>();

    public Exam () {

    }

    public Exam(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }
}

package fr.epita.quiz.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CONTENT")
    private String questionContent;

//    @ElementCollection
//    private something to do with MCQChoice????

    public Question() {

    }

    public Question(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getId() {
        return id;
    }

    public void setContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getContent() {
        return questionContent;
    }
}

package fr.epita.quiz.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "MCQCHOICE")
public class MCQChoice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CHOICE")
    private String choice;

    @Column(name = "VALID")
    private boolean valid = false;

    @ManyToOne
    private Question question;

    public MCQChoice() {

    }

    public MCQChoice(String choice) {
        this.choice = choice;
    }

    public MCQChoice(String choice, Question question) {
        this.choice = choice;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Question getQuestion() {
        return question;
    }
}

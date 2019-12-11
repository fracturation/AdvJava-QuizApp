package fr.epita.quiz.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "MCQANSWER")
public class MCQAnswer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @OneToOne
    private User user;

    @OneToOne
    private Exam exam;

    @OneToOne
    private MCQChoice choice;

    public MCQAnswer() {

    }

    public MCQAnswer(User user, Exam exam, MCQChoice choice) {
        this.user = user;
        this.exam = exam;
        this.choice = choice;
    }

    public User getUser() {
        return user;
    }

    public Exam getExam() {
        return exam;
    }

    public MCQChoice getChoice() {
        return choice;
    }

    public Integer getId() {
        return id;
    }
}

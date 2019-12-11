package fr.epita.quiz.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ISADMIN")
    private boolean isAdmin = false;

    @Column(name = "TOKEN")
    private String authToken;

    public User() {

    }

    public User(String firstname, String password) {
        this.name = firstname;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}

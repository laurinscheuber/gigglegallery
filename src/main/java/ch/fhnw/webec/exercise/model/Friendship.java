package ch.fhnw.webec.exercise.model;

import ch.fhnw.webec.exercise.form.SelectOption;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FRIENDSHIP")
public class Friendship implements SelectOption {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

package ch.fhnw.webec.exercise.model;

import ch.fhnw.webec.exercise.form.SelectOption;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FRIENDSHIP")
public class Friendship implements SelectOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private Users friend;

    @Override
    public String getValue() {
        return String.valueOf(id);
    }

    @Override
    public String getLabel() {
        return friend.getUsername();
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
    public Users getFriend(){return friend;}

    public void setFriend(Users friend) {this.friend = friend;}
}

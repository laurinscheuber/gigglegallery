package ch.fhnw.webec.exercise.model;

import ch.fhnw.webec.exercise.form.SelectOption;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table (name = "CATEGORY")
public class Category implements SelectOption {
    @Id
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<Friendship> friendshipList;

    public List<Friendship> getFriendshipList() {
        return friendshipList;
    }

    public void setFriendshipList(List<Friendship> friendshipList) {
        this.friendshipList = friendshipList;
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }
}

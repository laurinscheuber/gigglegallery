package ch.fhnw.webec.exercise.model;

import ch.fhnw.webec.exercise.form.SelectOption;
import jakarta.persistence.Id;

public class Category implements SelectOption {
    @Id
    private int id;
    private String name;

    public int getId() {
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

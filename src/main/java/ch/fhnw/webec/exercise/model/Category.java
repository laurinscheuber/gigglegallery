package ch.fhnw.webec.exercise.model;

import ch.fhnw.webec.exercise.form.SelectOption;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

public class Category implements SelectOption {
    @Id
    private int id;
    @NotEmpty
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

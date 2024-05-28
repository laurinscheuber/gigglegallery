package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findCategoryByName(String name);

}

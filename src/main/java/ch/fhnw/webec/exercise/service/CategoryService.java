package ch.fhnw.webec.exercise.service;

import ch.fhnw.webec.exercise.model.Category;
import ch.fhnw.webec.exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(String id, Category updatedCategory) {
        return categoryRepository.findById(id)
            .map(category -> {
                category.setName(updatedCategory.getName());
                return categoryRepository.save(category);
            })
            .orElseGet(() -> {
                updatedCategory.setId(id);
                return categoryRepository.save(updatedCategory);
            });
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}
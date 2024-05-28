package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Category;
import ch.fhnw.webec.exercise.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";
    }

    @GetMapping("/add")
    public String getAddCategoryForm() {
        return "category-add";
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}")
    public String getEditCategoryForm(@PathVariable String id, Model model) {
        Category category = categoryRepository.findById(id).orElseThrow();
        model.addAttribute("category", category);
        return "category-edit";
    }

    @PostMapping("/{id}")
    public String editCategory(@PathVariable String id, @RequestParam String name) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/category";
    }
}
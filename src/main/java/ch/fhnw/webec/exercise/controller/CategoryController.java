package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Category;
import ch.fhnw.webec.exercise.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String getAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-add";
    }

    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "categoryForm";
        }
        // Speichern der Kategorie
        return "redirect:/categories";
    }

    @GetMapping("/{id}")
    public String getEditCategoryForm(@PathVariable String id, Model model) {
        Category category = categoryRepository.findById(id).orElseThrow();
        model.addAttribute("category", category);
        return "category-edit";
    }

    @PostMapping("/{id}")
    public String editCategory(@PathVariable String id, @Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category-edit";
        }
        Category existingCategory = categoryRepository.findById(id).orElseThrow();
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
        return "redirect:/category";
    }

}
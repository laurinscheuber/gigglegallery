package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Category;
import ch.fhnw.webec.exercise.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category";
    }


    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category-add";
        }
        categoryService.addCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}")
    public String getEditCategoryForm(@PathVariable String id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category-edit";
        } else {
            model.addAttribute("error", "Category not found");
            return "redirect:/category";
        }
    }

    @PostMapping("/{id}")
    public String editCategory(@PathVariable String id, @Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category-edit";
        }
        categoryService.updateCategory(id, category);
        return "redirect:/category";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }

    @GetMapping("/categories")
    public String getAllCategories2(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category";
    }

    @PostMapping("/categories")
    public String createCategory(@ModelAttribute("categoryForm") Category category, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                // handle validation errors
                return "categories";
            }
            categoryService.saveCategory(category);
            return "redirect:/categories";
        } catch (Exception e) {
            // handle other exceptions
            model.addAttribute("error", "An error occurred while creating the category: " + e.getMessage());
            return "categories";
        }
    }

    @PostMapping("/categories/{id}")
    public String updateCategory(@PathVariable("id") String id, @ModelAttribute("categoryForm") Category category, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                // handle validation errors
                return "categories";
            }
            category.setId(id);
            categoryService.saveCategory(category);
            return "redirect:/categories";
        } catch (Exception e) {
            // handle other exceptions
            model.addAttribute("error", "An error occurred while updating the category: " + e.getMessage());
            return "categories";
        }
    }

}
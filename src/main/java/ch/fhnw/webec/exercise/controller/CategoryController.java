package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.repository.CategoryRepository;
import ch.fhnw.webec.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public String category() {
        return "category";
    }

}

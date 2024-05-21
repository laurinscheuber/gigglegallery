package ch.fhnw.webec.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Giggle Gallery");
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        return "index";
    }
}

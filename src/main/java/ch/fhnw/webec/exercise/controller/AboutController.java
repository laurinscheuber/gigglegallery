package ch.fhnw.webec.exercise.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {
    @RequestMapping(path = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }
}

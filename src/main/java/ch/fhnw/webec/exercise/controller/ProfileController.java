package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Users> users = userService.getAllUsers();
        model.addAttribute("users", users);

        // Fetch the friends list of the current user
        List<Users> friends = userService.getFriendsOfCurrentUser();
        model.addAttribute("friends", friends);

        return "profile";
    }


    @PostMapping("/profile/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/profile";
    }
}
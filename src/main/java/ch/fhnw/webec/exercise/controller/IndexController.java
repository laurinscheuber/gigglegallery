package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {
    @RequestMapping(path = "/")
    public String index(Model model) {
        return "index";
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String getIndex(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users currentUser = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        // get the current user's friends
        List<Long> friends = userRepository.findFriendIdsByUserId(currentUser.getId());

        // check if the friends list is null or contains any null elements
        if (friends == null || friends.contains(null)) {
            // handle the error
            return "error";
        }

        // add the current user and friends list to the model
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("friends", friends);

        return "index";
    }


}

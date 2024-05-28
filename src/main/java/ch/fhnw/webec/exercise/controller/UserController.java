package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Friendship;
import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/index")
    public String getUserPage(Model model, Authentication authenticator) {
        authenticator.getPrincipal();
        var user = this.userRepository.findByUsername(authenticator.getName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        //Booklist add Bookreview
        //user.getFriendshipList();
        List<Users> friends = user.getFriendshipList().stream().map(Friendship::getFriend).collect(Collectors.toList());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("guiltyPleasurePlaylist", user.getGuiltyPleasurePlaylist());
        model.addAttribute("bingeWatchingBeichte", user.getBingeWatchingBeichte());
        model.addAttribute("zeitreiseZiel", user.getZeitreiseZiel());
        model.addAttribute("superheldenSpitzname", user.getSuperheldenSpitzname());
        model.addAttribute("favoriteGIF", user.getFavoriteGIF());
        model.addAttribute("getFriendshipList", friends);
        return "index";
    }
}

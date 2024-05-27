package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Friendship;
import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.repository.FriendshipRepository;
import ch.fhnw.webec.exercise.repository.UserRepository;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendshipRepository friendshipRepository;


    @GetMapping("/user/{id}")
    public String getUserPage(@PathVariable Long id, Model model) {
        Users user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        List<Friendship> friendships = friendshipRepository.findByUserId(id);
        List<Users> friends = friendships.stream().map(Friendship::getFriend).collect(Collectors.toList());
        model.addAttribute("title", "Giggle Gallery");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("guiltyPleasurePlaylist", user.getGuiltyPleasurePlaylist());
        model.addAttribute("bingeWatchingConfession", user.getBingeWatchingBeichte());
        model.addAttribute("timeTravelDestination", user.getZeitreiseZiel());
        model.addAttribute("superheroNickname", user.getSuperheldenSpitzname());
        model.addAttribute("favoriteGif", user.getFavoriteGIF());
        return "index";
    }
}

package ch.fhnw.webec.exercise.controller;
import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;
import java.util.Set;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    public String login(Authentication authentication, @RequestParam("error") Optional<String> error, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        } else {
            model.addAttribute("hasLoginError", error.isPresent() && error.get().equals("true"));

            return "/login/login";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Users());
        return "login/registration";
    }

    @PostMapping("/register")
    public String registerUser(@Valid Users user, BindingResult bindingResult, Model model) {
        if (this.userService.usernameAlreadyExists(user.getUsername())) {
            bindingResult.addError(new FieldError("user", "username", "Username already exists"));
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "login/registration";
        } else {
            this.userService.addUser(
                    user.getUsername(),
                    user.getPassword(),
                    Set.of("ROLE_USER"),
                    user.getGuiltyPleasurePlaylist(),
                    user.getBingeWatchingBeichte(),
                    user.getZeitreiseZiel(),
                    user.getSuperheldenSpitzname(),
                    user.getFavoriteGIF()
            );
            return "redirect:/login";
        }
    }
}

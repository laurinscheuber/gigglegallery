package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> listUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUser(@PathVariable String username) {
        Users user = (Users) userService.loadUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}

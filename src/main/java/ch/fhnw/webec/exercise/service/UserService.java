package ch.fhnw.webec.exercise.service;

import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(String username, String password, Set<String> authorities, String guiltyPleasurePlaylist, String bingeWatchingBeichte, String zeitreiseZiel, String superheldenSpitzname, String favoriteGIF) {
        Users user = new Users(username, this.passwordEncoder.encode(password), authorities, guiltyPleasurePlaylist, bingeWatchingBeichte, zeitreiseZiel, superheldenSpitzname, favoriteGIF);
        this.userRepository.save(user);
    }

    public boolean usernameAlreadyExists(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found."));
    }

    public long getUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getId();
    }

    public void saveFavoriteGif(Long userId, String gifUrl) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFavoriteGIF(gifUrl);
        userRepository.save(user);
    }

    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

}

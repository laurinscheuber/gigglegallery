package ch.fhnw.webec.exercise.service;

import ch.fhnw.webec.exercise.model.Users;
import ch.fhnw.webec.exercise.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser() {
        Users user = new Users();
        user.setUsername("testuser");
        user.setPassword("password");

        Set<String> authorities = new HashSet<>();
        authorities.add("ROLE_USER");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(Users.class))).thenReturn(user);

        userService.addUser(
            user.getUsername(),
            user.getPassword(),
            authorities,
            "guiltyPleasurePlaylist",
            "bingeWatchingBeichte",
            "zeitreiseZiel",
            "superheldenSpitzname",
            "favoriteGIF"
        );

        verify(userRepository, times(1)).save(any(Users.class));
    }
}
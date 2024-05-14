package ch.fhnw.webec.exercise.service;

import ch.fhnw.webec.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Set;

@Lazy
@Component
public class AddAdminUser {
    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String password;
    private final UserService userService;

    public AddAdminUser(UserService userService) {
        this.userService = userService;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefreshed() {
        try {
            this.userService.loadUserByUsername(this.username);
        } catch (UsernameNotFoundException e) {
            this.userService.addUser(this.username, this.password, Set.of("ROLE_ADMIN"));
        }
    }
}

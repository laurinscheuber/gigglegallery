package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        Users user = new Users();
        user.setUsername("integrationTestUser");
        userRepository.save(user);

        Optional<Users> foundUser = userRepository.findByUsername("integrationTestUser");
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo("integrationTestUser");
    }
}
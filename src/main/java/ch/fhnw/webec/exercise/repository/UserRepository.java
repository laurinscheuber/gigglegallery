package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

    @Query("SELECT f.friend.id FROM Friendship f WHERE f.user.id = :userId")
    List<Long> findFriendIdsByUserId(@Param("userId") Long userId);

}

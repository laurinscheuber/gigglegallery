package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Friendship;
import org.h2.engine.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    List<Friendship> findByUserId(Long userId);
}

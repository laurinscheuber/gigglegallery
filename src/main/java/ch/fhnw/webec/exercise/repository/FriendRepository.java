package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friendship, Long> {

}

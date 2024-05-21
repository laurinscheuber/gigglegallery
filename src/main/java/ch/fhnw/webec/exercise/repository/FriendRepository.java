package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friendship, Long> {

}

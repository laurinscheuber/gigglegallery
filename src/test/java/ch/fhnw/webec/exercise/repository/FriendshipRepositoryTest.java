//package ch.fhnw.webec.exercise.repository;
//
//import ch.fhnw.webec.exercise.model.Friendship;
//import ch.fhnw.webec.exercise.model.Users;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class FriendshipRepositoryTest {
//
//    @Autowired
//    private FriendshipRepository friendshipRepository;
//
//    @Test
//    public void testFindByUserId() {
//        Users user = new Users();
//        user.setId(1);
//
//        Friendship friendship = new Friendship();
//        friendship.setUser(user);
//        friendshipRepository.save(friendship);
//
//        List<Friendship> foundFriendships = friendshipRepository.findByUserId(1L);
//        assertThat(foundFriendships).isNotEmpty();
//        assertThat(foundFriendships.get(0).getUser().getId()).isEqualTo(1L);
//    }
//}
package LukaszSz90.arachnohobbyapp.domain.repository;

import LukaszSz90.arachnohobbyapp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    User getUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User getAuthenticatedUser(String username);

}

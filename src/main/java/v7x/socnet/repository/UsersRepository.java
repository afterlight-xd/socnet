package v7x.socnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v7x.socnet.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByLogin(String login);
}

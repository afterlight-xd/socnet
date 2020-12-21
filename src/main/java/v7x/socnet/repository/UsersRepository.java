package v7x.socnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v7x.socnet.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}

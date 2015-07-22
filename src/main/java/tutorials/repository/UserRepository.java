package tutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutorials.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

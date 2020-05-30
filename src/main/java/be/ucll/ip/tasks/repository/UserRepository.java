package be.ucll.ip.tasks.repository;

import be.ucll.ip.tasks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

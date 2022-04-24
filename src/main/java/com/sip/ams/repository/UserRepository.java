package com.sip.ams.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.User;
@EnableJpaRepositories
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
 User findByEmail(String email);
}

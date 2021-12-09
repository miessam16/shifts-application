package essam.com.example.Shift.Application.repositories;

import essam.com.example.Shift.Application.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByPhoneNumber(String phoneNumber);
    public boolean existsByPhoneNumber(String phoneNumber);
}

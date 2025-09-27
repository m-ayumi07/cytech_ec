package jp.co.sss.cytech.domain.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import jp.co.sss.cytech.domain.entity.User;
public interface UserRepository extends JpaRepository<User, Long> { Optional<User> findByEmail(String email); }

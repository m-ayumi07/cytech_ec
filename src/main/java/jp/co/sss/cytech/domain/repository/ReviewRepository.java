package jp.co.sss.cytech.domain.repository;
import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
import jp.co.sss.cytech.domain.entity.Review;
public interface ReviewRepository extends JpaRepository<Review, Long> {
 List<Review> findByProduct_IdOrderByCreatedAtDesc(Long productId);
}

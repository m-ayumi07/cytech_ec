package jp.co.sss.cytech.domain.repository;
import java.util.*; import org.springframework.data.jpa.repository.JpaRepository;
import jp.co.sss.cytech.domain.entity.Cart;
public interface CartRepository extends JpaRepository<Cart, Long> {
 List<Cart> findByUser_Id(Long userId);
 Optional<Cart> findByUser_IdAndProduct_Id(Long userId, Long productId);
}

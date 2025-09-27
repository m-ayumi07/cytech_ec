package jp.co.sss.cytech.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository; import jp.co.sss.cytech.domain.entity.OrderItem;
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}

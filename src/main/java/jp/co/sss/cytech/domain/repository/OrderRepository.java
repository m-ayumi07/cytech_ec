package jp.co.sss.cytech.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository; import jp.co.sss.cytech.domain.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {}

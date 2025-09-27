package jp.co.sss.cytech.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository; import jp.co.sss.cytech.domain.entity.SalesItem;
public interface SalesItemRepository extends JpaRepository<SalesItem, Long> {}

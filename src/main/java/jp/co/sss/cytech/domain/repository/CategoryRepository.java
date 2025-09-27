package jp.co.sss.cytech.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jp.co.sss.cytech.domain.entity.Category;
public interface CategoryRepository extends JpaRepository<Category, Long> {}

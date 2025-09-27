package jp.co.sss.cytech.domain.repository;
import java.util.*; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param;
import jp.co.sss.cytech.domain.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
 List<Product> findByProductNameContainingIgnoreCase(String productName);
 @Query("select p from Product p where lower(p.company.companyName) like lower(concat('%', :company, '%'))")
 List<Product> searchByCompany(@Param("company") String company);
 List<Product> findByCategory_Id(Long categoryId);
}

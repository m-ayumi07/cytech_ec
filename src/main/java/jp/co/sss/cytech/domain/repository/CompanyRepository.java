package jp.co.sss.cytech.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jp.co.sss.cytech.domain.entity.Company;
public interface CompanyRepository extends JpaRepository<Company, Long> {}

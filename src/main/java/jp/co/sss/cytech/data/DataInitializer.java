package jp.co.sss.cytech.data;
import jp.co.sss.cytech.domain.entity.*; import jp.co.sss.cytech.domain.repository.*;
import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.Configuration; import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Configuration
public class DataInitializer implements CommandLineRunner {
    private final CompanyRepository companies; private final CategoryRepository categories; private final ProductRepository products;
    public DataInitializer(CompanyRepository companies, CategoryRepository categories, ProductRepository products){ this.companies=companies; this.categories=categories; this.products=products; }
    @Override @Transactional public void run(String... args) {
        if(companies.count()==0){
            Company c1=new Company(); c1.setCompanyName("Alpha Co."); c1.setStreetAddress("Tokyo"); c1.setRepresentativeName("A. CEO"); companies.save(c1);
            Company c2=new Company(); c2.setCompanyName("Beta Inc."); c2.setStreetAddress("Osaka"); c2.setRepresentativeName("B. CEO"); companies.save(c2);
            Category g1=new Category(); g1.setCategoryName("Food"); g1.setDescription("Foods"); g1.setParentId(0); categories.save(g1);
            Category g2=new Category(); g2.setCategoryName("Drink"); g2.setDescription("Drinks"); g2.setParentId(0); categories.save(g2);
            Product p1=p("Apple",100,50,"Fresh apple","/img/apple.png",c1,g1);
            Product p2=p("Orange Juice",200,80,"OJ","/img/oj.png",c2,g2);
            Product p3=p("Bread",150,40,"Bread","/img/bread.png",c1,g1);
            Product p4=p("Milk",180,30,"Milk","/img/milk.png",c2,g2);
            Product p5=p("Cookie",120,70,"Cookie","/img/cookie.png",c1,g1);
            products.saveAll(List.of(p1,p2,p3,p4,p5));
        }
    }
    private Product p(String name,int price,int stock,String comment,String img,Company company,Category category){
        Product p=new Product(); p.setProductName(name); p.setPrice(price); p.setStock(stock); p.setComment(comment);
        p.setImgPath(img); p.setCompany(company); p.setCategory(category); p.setIncludeTax((int)Math.round(price*1.10)); return p;
    }
}

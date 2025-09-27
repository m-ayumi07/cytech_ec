package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="sales_items")
public class SalesItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="sale_item_id") private Long id;
 @ManyToOne @JoinColumn(name="product_id", nullable=false) private Product product;
 @ManyToOne @JoinColumn(name="company_id", nullable=false) private Company company;
 @Column(name="sale_name", nullable=false) private String saleName;
 @Column(nullable=false) private String description;
 @Column(name="discount_rate", nullable=false) private Integer discountRate;
 @Column(name="sales_img_path", nullable=false) private String salesImgPath;
 @Column(name="start_month") private LocalDateTime startMonth;
 @Column(name="end_month") private LocalDateTime endMonth;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
 public Company getCompany(){return company;} public void setCompany(Company company){this.company=company;}
 public String getSaleName(){return saleName;} public void setSaleName(String saleName){this.saleName=saleName;}
 public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
 public Integer getDiscountRate(){return discountRate;} public void setDiscountRate(Integer discountRate){this.discountRate=discountRate;}
 public String getSalesImgPath(){return salesImgPath;} public void setSalesImgPath(String salesImgPath){this.salesImgPath=salesImgPath;}
 public LocalDateTime getStartMonth(){return startMonth;} public void setStartMonth(LocalDateTime startMonth){this.startMonth=startMonth;}
 public LocalDateTime getEndMonth(){return endMonth;} public void setEndMonth(LocalDateTime endMonth){this.endMonth=endMonth;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

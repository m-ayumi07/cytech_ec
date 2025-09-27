package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="product_id") private Long id;
 @Column(name="product_name", nullable=false) private String productName;
 @Column(nullable=false) private Integer price;
 @Column(name="tax_price") private Integer taxPrice;
 @Column(nullable=false) private Integer stock;
 @Column(nullable=false) private String comment;
 @Column(name="img_path", nullable=false) private String imgPath;
 @ManyToOne @JoinColumn(name="company_id", nullable=false) private Company company;
 @ManyToOne @JoinColumn(name="category_id") private Category category;
 @Column(name="include_tax", nullable=false) private Integer includeTax;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 @PrePersist @PreUpdate public void calcTaxPrice(){ if(price!=null){ this.includeTax=(int)Math.round(price*1.10);} }
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getProductName(){return productName;} public void setProductName(String productName){this.productName=productName;}
 public Integer getPrice(){return price;} public void setPrice(Integer price){this.price=price;}
 public Integer getTaxPrice(){return taxPrice;} public void setTaxPrice(Integer taxPrice){this.taxPrice=taxPrice;}
 public Integer getStock(){return stock;} public void setStock(Integer stock){this.stock=stock;}
 public String getComment(){return comment;} public void setComment(String comment){this.comment=comment;}
 public String getImgPath(){return imgPath;} public void setImgPath(String imgPath){this.imgPath=imgPath;}
 public Company getCompany(){return company;} public void setCompany(Company company){this.company=company;}
 public Category getCategory(){return category;} public void setCategory(Category category){this.category=category;}
 public Integer getIncludeTax(){return includeTax;} public void setIncludeTax(Integer includeTax){this.includeTax=includeTax;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

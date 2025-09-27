package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="carts")
public class Cart {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="cart_id") private Long id;
 @ManyToOne @JoinColumn(name="user_id", nullable=false) private User user;
 @ManyToOne @JoinColumn(name="product_id", nullable=false) private Product product;
 @Column(nullable=false) private Integer quantity;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public User getUser(){return user;} public void setUser(User user){this.user=user;}
 public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
 public Integer getQuantity(){return quantity;} public void setQuantity(Integer quantity){this.quantity=quantity;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

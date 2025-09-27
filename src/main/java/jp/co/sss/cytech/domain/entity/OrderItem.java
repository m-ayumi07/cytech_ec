package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="order_items")
public class OrderItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="orderItem_id") private Long id;
 @ManyToOne @JoinColumn(name="order_id", nullable=false) private Order order;
 @ManyToOne @JoinColumn(name="product_id", nullable=false) private Product product;
 @Column(nullable=false) private Integer quantity;
 @Column(nullable=false) private Integer price;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public Order getOrder(){return order;} public void setOrder(Order order){this.order=order;}
 public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
 public Integer getQuantity(){return quantity;} public void setQuantity(Integer quantity){this.quantity=quantity;}
 public Integer getPrice(){return price;} public void setPrice(Integer price){this.price=price;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="orders")
public class Order {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="order_id") private Long id;
 @ManyToOne @JoinColumn(name="user_id", nullable=false) private User user;
 @Column(name="total_amount", nullable=false) private Integer totalAmount;
 @Column(nullable=false) private String status;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public User getUser(){return user;} public void setUser(User user){this.user=user;}
 public Integer getTotalAmount(){return totalAmount;} public void setTotalAmount(Integer totalAmount){this.totalAmount=totalAmount;}
 public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

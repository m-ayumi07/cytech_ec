package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="reviews")
public class Review {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="review_id") private Long id;
 @ManyToOne @JoinColumn(name="user_id", nullable=false) private User user;
 @ManyToOne @JoinColumn(name="product_id", nullable=false) private Product product;
 @Column(nullable=false) private Integer rating;
 @Column(nullable=false, length=300) private String comment;
 @Column(name="dummy_user_name", nullable=false) private String dummyUserName;
 @Column(name="review_img_path", nullable=false) private String reviewImgPath;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public User getUser(){return user;} public void setUser(User user){this.user=user;}
 public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
 public Integer getRating(){return rating;} public void setRating(Integer rating){this.rating=rating;}
 public String getComment(){return comment;} public void setComment(String comment){this.comment=comment;}
 public String getDummyUserName(){return dummyUserName;} public void setDummyUserName(String dummyUserName){this.dummyUserName=dummyUserName;}
 public String getReviewImgPath(){return reviewImgPath;} public void setReviewImgPath(String reviewImgPath){this.reviewImgPath=reviewImgPath;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

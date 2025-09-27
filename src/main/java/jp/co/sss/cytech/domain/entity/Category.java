package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="categories")
public class Category {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="category_id") private Long id;
 @Column(name="category_name", nullable=false) private String categoryName;
 @Column(nullable=false) private String description;
 @Column(name="parent_id", nullable=false) private Integer parentId;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getCategoryName(){return categoryName;} public void setCategoryName(String categoryName){this.categoryName=categoryName;}
 public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
 public Integer getParentId(){return parentId;} public void setParentId(Integer parentId){this.parentId=parentId;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

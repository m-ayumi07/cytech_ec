package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="companies")
public class Company {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="company_id") private Long id;
 @Column(name="company_name", nullable=false) private String companyName;
 @Column(name="street_address", nullable=false) private String streetAddress;
 @Column(name="representative_name", nullable=false) private String representativeName;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getCompanyName(){return companyName;} public void setCompanyName(String companyName){this.companyName=companyName;}
 public String getStreetAddress(){return streetAddress;} public void setStreetAddress(String streetAddress){this.streetAddress=streetAddress;}
 public String getRepresentativeName(){return representativeName;} public void setRepresentativeName(String representativeName){this.representativeName=representativeName;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

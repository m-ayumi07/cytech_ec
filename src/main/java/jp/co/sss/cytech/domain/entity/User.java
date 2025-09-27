package jp.co.sss.cytech.domain.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="user_id") private Long id;
 @Column(name="user_name", nullable=false) private String userName;
 @Column(name="user_name_kana", nullable=false) private String userNameKana;
 @Column(nullable=false, unique=true) private String email;
 @Column(nullable=false) private String phone;
 @Column(name="user_address", nullable=false) private String userAddress;
 @Column(name="passwords", nullable=false) private String password;
 @Column(name="created_at") private LocalDateTime createdAt = LocalDateTime.now();
 @Column(name="updated_at") private LocalDateTime updatedAt = LocalDateTime.now();
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getUserName(){return userName;} public void setUserName(String userName){this.userName=userName;}
 public String getUserNameKana(){return userNameKana;} public void setUserNameKana(String userNameKana){this.userNameKana=userNameKana;}
 public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
 public String getPhone(){return phone;} public void setPhone(String phone){this.phone=phone;}
 public String getUserAddress(){return userAddress;} public void setUserAddress(String userAddress){this.userAddress=userAddress;}
 public String getPassword(){return password;} public void setPassword(String password){this.password=password;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
}

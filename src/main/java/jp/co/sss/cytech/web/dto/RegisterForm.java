package jp.co.sss.cytech.web.dto;
import jakarta.validation.constraints.*;
public class RegisterForm {
    @NotBlank private String userName; @NotBlank private String userNameKana;
    @Email @NotBlank private String email; @NotBlank private String phone;
    @NotBlank private String userAddress;
    @Pattern(regexp="^[a-zA-Z0-9]{8,}$", message="英数字8文字以上") private String password;
    @NotBlank private String confirmPassword;
    public String getUserName(){return userName;} public void setUserName(String v){userName=v;}
    public String getUserNameKana(){return userNameKana;} public void setUserNameKana(String v){userNameKana=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getUserAddress(){return userAddress;} public void setUserAddress(String v){userAddress=v;}
    public String getPassword(){return password;} public void setPassword(String v){password=v;}
    public String getConfirmPassword(){return confirmPassword;} public void setConfirmPassword(String v){confirmPassword=v;}
}

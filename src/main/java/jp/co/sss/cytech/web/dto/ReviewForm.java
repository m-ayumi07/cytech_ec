package jp.co.sss.cytech.web.dto;
import jakarta.validation.constraints.*;
public class ReviewForm {
    @NotBlank private String userName; @Email @NotBlank private String email;
    @Min(1) @Max(5) private int rating; @NotBlank @Size(max=300) private String comment;
    private String imagePath;
    public String getUserName(){return userName;} public void setUserName(String v){userName=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public int getRating(){return rating;} public void setRating(int v){rating=v;}
    public String getComment(){return comment;} public void setComment(String v){comment=v;}
    public String getImagePath(){return imagePath;} public void setImagePath(String v){imagePath=v;}
}

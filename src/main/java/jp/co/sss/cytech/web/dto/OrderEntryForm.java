package jp.co.sss.cytech.web.dto;
import jakarta.validation.constraints.*;
public class OrderEntryForm {
    @NotBlank private String name; @NotBlank private String address; private String apartment;
    @Pattern(regexp="^[0-9]{15}$", message="カード番号は15桁の数字") private String cardNumber;
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getAddress(){return address;} public void setAddress(String v){address=v;}
    public String getApartment(){return apartment;} public void setApartment(String v){apartment=v;}
    public String getCardNumber(){return cardNumber;} public void setCardNumber(String v){cardNumber=v;}
}

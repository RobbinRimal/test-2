package com.example.demo;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class RegistrationForm {
    private String username;

    private String  password;
    private String  fullname;
    private String  street;
    private String  city;
    private String state;
    private String  zip;
    private String phone;


    public UserInfo toUser(PasswordEncoder passwordEncoder) {
        return new UserInfo(username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}

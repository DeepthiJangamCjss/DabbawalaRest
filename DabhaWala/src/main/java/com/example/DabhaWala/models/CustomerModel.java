package com.example.DabhaWala.models;

import com.example.DabhaWala.entity.CustomerOrder;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private int customerId;
    @NotNull(message = "username should not be null")
    @NotBlank(message = "username should not be blank")
    @Size(min=5,max=15,message = "username should have 5 to 15 characters")
    private String username;
    @NotNull(message = "password should not be null")
    @NotBlank(message = "password should not be blank")
    private String password;
    @Size(min=4,message = "name should be atleast four characters")
    private String name;
    @Min(18)
    private int age;
    @Email(message = "Invalid email format")
    private String email;
    private String MembershipType="Normal";
    private String accountBalance;
    private List<CustomerOrder> orderList=new ArrayList<>();

    @Override
    public String toString() {
        return "CustomerModel{" +
                "customerId=" + customerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", MembershipType='" + MembershipType + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                '}';
    }
}

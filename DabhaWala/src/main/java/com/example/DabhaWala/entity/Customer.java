package com.example.DabhaWala.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String username;
    private String password;
    private String name;
    private int age;
    private String email;
    private String MembershipType="Normal";
    private String accountBalance;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<CustomerOrder> orderList=new ArrayList<>();

    @Override
    public String toString() {
        return "Customer{" +
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

package com.example.DabhaWala.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ownerId;
    private String username;
    private String password;
    private String ownerName;
    private String email;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurantOwner")
    @JsonIgnore
    private List<Restaurant> restaurantList;

    @Override
    public String toString() {
        return "RestaurantOwner{" +
                "ownerId=" + ownerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

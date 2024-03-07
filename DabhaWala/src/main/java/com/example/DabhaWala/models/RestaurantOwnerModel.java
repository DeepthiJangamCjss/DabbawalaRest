package com.example.DabhaWala.models;

import com.example.DabhaWala.entity.Restaurant;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOwnerModel {
    private int ownerId;
    @NotNull(message = "username should not be null")
    @NotBlank(message = "username should not be blank")
    @Size(min=5,max=15,message = "username should have 5 to 15 characters")
    private String username;
    @NotNull(message = "password should not be null")
    @NotBlank(message = "password should not be blank")
    private String password;
    @NotNull(message = "username should not be null")
    @NotBlank(message = "username should not be blank")
    @Size(min=5,message = "owner name should be atleast 5 letters")
    private String ownerName;
    @Email(message = "invalid email format")
    private String email;
    private List<Restaurant> restaurantList=new ArrayList<>();

    @Override
    public String toString() {
        return "RestaurantOwnerModel{" +
                "ownerId=" + ownerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

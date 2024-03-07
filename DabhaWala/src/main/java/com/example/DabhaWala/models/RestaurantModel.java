package com.example.DabhaWala.models;

import com.example.DabhaWala.entity.Location;
import com.example.DabhaWala.entity.Recepie;
import com.example.DabhaWala.entity.RestaurantOwner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantModel {
    private int restaurantId;
    @NotNull(message = "restaurant name should not be null")
    @NotBlank(message = "restaurant name should not be blank")
    private String restaurantName;
    @NotNull(message = "street should not be null")
    @NotBlank(message = "street should not be blank")
    private String street;
    @NotNull(message = "city should not be null")
    @NotBlank(message = "city should not be blank")
    private String city;
    @NotNull(message = "state should not be null")
    @NotBlank(message = "state should not be blank")
    private String state;
    private RestaurantOwner restaurantOwner;
    private List<Recepie> recepieList=new ArrayList<>();
    private List<Location> locationList=new ArrayList<>();

    @Override
    public String toString() {
        return "RestaurantModel{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

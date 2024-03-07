package com.example.DabhaWala.entity;
d
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurantId;
    private String restaurantName;
    private String street;
    private String city;
    private String state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ownerId")
    @JsonIgnore
    private RestaurantOwner restaurantOwner;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Recepie> recepieList=new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="restaurant_location", joinColumns = @JoinColumn(name="restaurant_Id"),
    inverseJoinColumns = @JoinColumn(name="location_Id"))
    @JsonIgnore
    private List<Location> locationList=new ArrayList<>();

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

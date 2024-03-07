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
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    private String street;
    private String city;
    private String state;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "locationList")
    private List<Restaurant> restaurantList=new ArrayList<>();

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

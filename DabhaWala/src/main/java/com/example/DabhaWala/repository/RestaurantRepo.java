package com.example.DabhaWala.repository;

import com.example.DabhaWala.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
    Restaurant findByRestaurantName(String restaurantName);
}

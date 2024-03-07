package com.example.DabhaWala.repository;

import com.example.DabhaWala.entity.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOwnerRepo extends JpaRepository<RestaurantOwner,Integer> {
    boolean existsByUsername(String username);
}

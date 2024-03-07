package com.example.DabhaWala.repository;

import com.example.DabhaWala.entity.Location;
import com.example.DabhaWala.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location,Integer> {
    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END FROM Location l WHERE l.street = :street AND l.city = :city AND l.state = :state")
    boolean checkIfAvailable(@Param("street") String street, @Param("city") String city, @Param("state") String state);

}

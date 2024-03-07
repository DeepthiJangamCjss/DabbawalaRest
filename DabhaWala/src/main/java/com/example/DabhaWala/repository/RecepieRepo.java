package com.example.DabhaWala.repository;

import com.example.DabhaWala.entity.Recepie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepieRepo extends JpaRepository<Recepie,Integer> {
}

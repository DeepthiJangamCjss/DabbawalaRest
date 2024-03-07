package com.example.DabhaWala.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Recepie{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recepieId;
    private String recepieName;
    private int price;
    private boolean isPremiumRecepie;

    @ManyToOne
    @JoinColumn(name="restaurant_Id")
    private Restaurant restaurant;

    @Override
    public String toString() {
        return "Recepie{" +
                "recepieId=" + recepieId +
                ", recepieName=" + recepieName +
                ", price=" + price +
                ", isPremiumRecepie=" + isPremiumRecepie +
                '}';
    }
}

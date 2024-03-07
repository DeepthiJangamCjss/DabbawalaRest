package com.example.DabhaWala.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int recepieId;
    private int restaurantId;
    private int amount;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderId=" + orderId +
                ", recepieId=" + recepieId +
                ", restaurantId=" + restaurantId +
                ", amount=" + amount +
                '}';
    }
}

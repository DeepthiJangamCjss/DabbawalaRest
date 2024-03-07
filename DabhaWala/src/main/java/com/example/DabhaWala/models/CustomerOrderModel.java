package com.example.DabhaWala.models;

import com.example.DabhaWala.entity.Customer;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderModel {
    private int orderId;
    private int recepieId;
    private int restaurantId;
    private int amount;
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerOrderModel{" +
                "orderId=" + orderId +
                ", recepieId=" + recepieId +
                ", restaurantId=" + restaurantId +
                ", amount=" + amount +
                '}';
    }
}

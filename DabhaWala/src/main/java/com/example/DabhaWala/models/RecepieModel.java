package com.example.DabhaWala.models;

import com.example.DabhaWala.entity.Restaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecepieModel {
    private int recepieId;
    @NotNull(message = "recepie name should not be null")
    @NotBlank(message = "recepie name should not be blank")
    private String recepieName;
    private int price;
    private boolean isPremiumRecepie;
    private Restaurant restaurant;

    @Override
    public String toString() {
        return "RecepieModel{" +
                "recepieId=" + recepieId +
                ", recepieName='" + recepieName + '\'' +
                ", price=" + price +
                ", isPremiumRecepie=" + isPremiumRecepie +
                '}';
    }
}

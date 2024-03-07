package com.example.DabhaWala.controller;

import com.example.DabhaWala.models.RecepieModel;
import com.example.DabhaWala.models.RestaurantModel;
import com.example.DabhaWala.models.RestaurantOwnerModel;
import com.example.DabhaWala.service.RestaurantOwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/restaurant")
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    @PostMapping("/registerOwner")
    public String restaurantOwnerRegister(@RequestBody @Valid RestaurantOwnerModel restaurantOwnerModel){
        return restaurantOwnerService.addRestaurantOwner(restaurantOwnerModel);
    }

    @GetMapping("/ownerDetails/{ownerId}")
    public RestaurantOwnerModel getOwnerDetails(@PathVariable("ownerId") int ownerId){
        return restaurantOwnerService.getOwnerDetails(ownerId);
    }

    @PostMapping("/addRestaurant/{ownerId}")
    public String addRestaurant(@PathVariable("ownerId") int ownerId,@RequestBody @Valid RestaurantModel restaurantModel) {
        return restaurantOwnerService.addRestaurant(ownerId,restaurantModel);
    }

    @GetMapping("/getRestaurantDetails/{restaurantId}")
    public RestaurantModel getRestaurantDetails(@PathVariable("restaurantId") int restaurantId) {
        return restaurantOwnerService.getRestaurantDetails(restaurantId);
    }

    @PostMapping("/addRecepie/{ownerId}")
    public String addRecipie(@PathVariable("ownerId") int ownerId, @RequestParam("restaurantId") int restaurantId, @RequestBody @Valid RecepieModel recepieModel){
        System.out.println(restaurantId+"  "+ownerId+"  "+recepieModel);
        return recepieModel.toString();
        //return restaurantOwnerService.addRecepie(ownerId,restaurantId,recepieModel);
    }
}

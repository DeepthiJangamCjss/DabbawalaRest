package com.example.DabhaWala.service;

import com.example.DabhaWala.entity.Recepie;
import com.example.DabhaWala.entity.Restaurant;
import com.example.DabhaWala.entity.RestaurantOwner;
import com.example.DabhaWala.models.RecepieModel;
import com.example.DabhaWala.models.RestaurantModel;
import com.example.DabhaWala.models.RestaurantOwnerModel;
import com.example.DabhaWala.repository.RecepieRepo;
import com.example.DabhaWala.repository.RestaurantOwnerRepo;
import com.example.DabhaWala.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantOwnerService {
    @Autowired
    private RestaurantOwnerRepo restaurantOwnerRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private RecepieRepo recepieRepo;

    public Restaurant restaurantModelToEntity(RestaurantModel restaurantModel){
        if(restaurantModel==null){
            return null;
        }
        Restaurant restaurant=new Restaurant();
        restaurant.setRestaurantId(restaurantModel.getRestaurantId());
        restaurant.setRestaurantName(restaurantModel.getRestaurantName());
        restaurant.setStreet(restaurantModel.getStreet());
        restaurant.setCity(restaurantModel.getCity());
        restaurant.setState(restaurantModel.getState());
        restaurant.setRestaurantOwner(restaurantModel.getRestaurantOwner());
        restaurant.setRecepieList(restaurantModel.getRecepieList());
        restaurant.setLocationList(restaurantModel.getLocationList());
        return restaurant;
    }
    public static RestaurantModel restaurantEntityToModel(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }

        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setRestaurantId(restaurant.getRestaurantId());
        restaurantModel.setRestaurantName(restaurant.getRestaurantName());
        restaurantModel.setStreet(restaurant.getStreet());
        restaurantModel.setCity(restaurant.getCity());
        restaurantModel.setState(restaurant.getState());
        restaurantModel.setRestaurantOwner(restaurant.getRestaurantOwner());
        restaurantModel.setRecepieList(restaurant.getRecepieList());
        restaurantModel.setLocationList(restaurant.getLocationList());

        return restaurantModel;
    }



    private RestaurantOwner restaurantOwnerModelToEntity(RestaurantOwnerModel restaurantOwnerModel) {
        if(restaurantOwnerModel==null){
            return null;
        }
        RestaurantOwner restaurantOwner=new RestaurantOwner();
        restaurantOwner.setOwnerId(restaurantOwnerModel.getOwnerId());
        restaurantOwner.setUsername(restaurantOwnerModel.getUsername());
        restaurantOwner.setPassword(restaurantOwnerModel.getPassword());
        restaurantOwner.setOwnerName(restaurantOwnerModel.getOwnerName());
        restaurantOwner.setEmail(restaurantOwnerModel.getEmail());
        restaurantOwner.setRestaurantList(restaurantOwnerModel.getRestaurantList());
        return restaurantOwner;
    }
    public RestaurantOwnerModel restaurantOwnerEntityToModel(RestaurantOwner restaurantOwner) {
        if (restaurantOwner == null) {
            return null;
        }
        RestaurantOwnerModel restaurantOwnerModel = new RestaurantOwnerModel();
        restaurantOwnerModel.setOwnerId(restaurantOwner.getOwnerId());
        restaurantOwnerModel.setUsername(restaurantOwner.getUsername());
        restaurantOwnerModel.setPassword(restaurantOwner.getPassword());
        restaurantOwnerModel.setOwnerName(restaurantOwner.getOwnerName());
        restaurantOwnerModel.setEmail(restaurantOwner.getEmail());
        restaurantOwnerModel.setRestaurantList(restaurantOwner.getRestaurantList());
        return restaurantOwnerModel;
    }

    public Recepie recepieModelToEntity(RecepieModel recepieModel){
        if(recepieModel==null){
            return null;
        }
        Recepie recepie=new Recepie();
        recepie.setRecepieId(recepieModel.getRecepieId());
        recepie.setRecepieName(recepieModel.getRecepieName());
        recepie.setPrice(recepieModel.getPrice());
        recepie.setPremiumRecepie(recepieModel.isPremiumRecepie());
        recepie.setRestaurant(recepieModel.getRestaurant());
        return recepie;
    }
    public RecepieModel recepieEntityToModel(Recepie recepie) {
        if(recepie==null){
            return null;
        }
        RecepieModel recepieModel = new RecepieModel();
        recepieModel.setRecepieId(recepie.getRecepieId());
        recepieModel.setRecepieName(recepie.getRecepieName());
        recepieModel.setPrice(recepie.getPrice());
        recepieModel.setPremiumRecepie(recepie.isPremiumRecepie());
        recepieModel.setRestaurant(recepie.getRestaurant());
        return recepieModel;
    }

    public String addRestaurantOwner(RestaurantOwnerModel restaurantOwnerModel) {
        boolean ownerExists = restaurantOwnerRepo.existsByUsername(restaurantOwnerModel.getUsername());
        if(ownerExists){
            return "Owner with this username already exists. Try with other username";
        }
        RestaurantOwner restaurantOwner=restaurantOwnerModelToEntity(restaurantOwnerModel);
        restaurantOwnerRepo.save(restaurantOwner);
        return "Restaurant Owner registered successfully";
    }


    public RestaurantOwnerModel getOwnerDetails(int ownerId) {
        if(restaurantOwnerRepo.findById(ownerId).isPresent()){
            RestaurantOwner restaurantOwner=restaurantOwnerRepo.getReferenceById(ownerId);
            return restaurantOwnerEntityToModel(restaurantOwner);
        }
        return null;
    }
    public String addRestaurant(int ownerId,RestaurantModel restaurantModel) {
        boolean restaurantOwnerFound=restaurantOwnerRepo.existsById(ownerId);
        if(!restaurantOwnerFound){
            return "Restaurant Owner id is not present";
        }
        Restaurant existingRestaurant = restaurantRepo.findByRestaurantName(restaurantModel.getRestaurantName());
        if (existingRestaurant != null) {
            return "Restaurant with this name already exists. Try with another name.";
        }
        RestaurantOwner restaurantOwner=restaurantOwnerRepo.getReferenceById(ownerId);
        Restaurant restaurant = restaurantModelToEntity(restaurantModel);
        List<Restaurant> restaurantList=restaurantOwner.getRestaurantList();
        restaurant.setRestaurantOwner(restaurantOwner);
        restaurantList.add(restaurant);
        restaurantOwner.setRestaurantList(restaurantList);
        restaurantOwnerRepo.save(restaurantOwner);
        return "Restaurant added successfully";
    }

    public RestaurantModel getRestaurantDetails(int restaurantId) {
        boolean restaurantExists = restaurantRepo.existsById(restaurantId);
        if (restaurantExists) {
            Restaurant restaurant = restaurantRepo.findById(restaurantId).orElse(null);
            if (restaurant != null) {
                return restaurantEntityToModel(restaurant);
            }
        }
        return null;
    }

    public String addRecepie(int ownerId,int restaurantId, RecepieModel recepieModel) {
        boolean restaurantOwnerFound=restaurantOwnerRepo.existsById(ownerId);
        if(!restaurantOwnerFound){
            return "Restaurant Owner id is not present";
        }
        boolean restaurantFound= restaurantRepo.existsById(restaurantId);
        if(!restaurantFound){
            return "restaurant with this id is not Available";
        }
        Recepie recepie=recepieModelToEntity(recepieModel);
        Restaurant restaurant=restaurantRepo.getReferenceById(restaurantId);
        if(recepie==null){
            return "Recepie not added";
        }
        recepie.setRestaurant(restaurant);
        recepieRepo.save(recepie);
        return  recepie.getRecepieName()+" Added Successfully";
    }
}

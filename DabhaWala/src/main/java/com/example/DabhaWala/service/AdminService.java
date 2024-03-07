package com.example.DabhaWala.service;

import com.example.DabhaWala.entity.Location;
import com.example.DabhaWala.models.LocationModel;
import com.example.DabhaWala.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private LocationRepo locationRepo;

    private Location locationModelToEntity(LocationModel locationModel) {
        Location location=new Location();
        location.setLocationId(locationModel.getLocationId());
        location.setStreet(locationModel.getStreet());
        location.setCity(locationModel.getCity());
        location.setState(locationModel.getState());
        location.setRestaurantList(locationModel.getRestaurantList());
        return location;
    }

    private LocationModel locationEntityToModel(Location location){
        LocationModel locationModel=new LocationModel();
        locationModel.setLocationId(location.getLocationId());
        locationModel.setStreet(location.getStreet());
        locationModel.setCity(location.getCity());
        locationModel.setState(location.getState());
        locationModel.setRestaurantList(location.getRestaurantList());
        return locationModel;
    }

    public String addLocation(LocationModel locationModel) {
        boolean isAvailable = locationRepo.checkIfAvailable(locationModel.getStreet(), locationModel.getCity(), locationModel.getState());
        if(isAvailable){
            return "Location Already available. Cannot add again";
        }

        Location location= locationModelToEntity(locationModel);
        locationRepo.save(location);
        return "Location added successfully";
    }

    public List<LocationModel> getAllLocations() {
        List<Location> locationList=locationRepo.findAll();
        List<LocationModel> locationModels=new ArrayList<>();
        locationList.forEach(location -> locationModels.add(locationEntityToModel(location)));
        return locationModels;
    }
}

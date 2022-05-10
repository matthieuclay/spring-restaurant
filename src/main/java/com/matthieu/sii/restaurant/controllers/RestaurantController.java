package com.matthieu.sii.restaurant.controllers;

import com.matthieu.sii.restaurant.models.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @GetMapping
    public List<Restaurant> findAll() {
        List<Restaurant> restaurantList = new ArrayList<Restaurant>();

        Restaurant restaurant = new Restaurant();
        restaurant.setId("1");
        restaurant.setName("Restaurant");
        restaurant.setAddress("123 Rue Bidon 69000 Moncul");

        restaurantList.add(restaurant);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setId("2");
        restaurant2.setName("Fastfood");
        restaurant2.setAddress("456 Rue Bidon 69000 Moncul");

        restaurantList.add(restaurant2);

        return restaurantList;
    }
}

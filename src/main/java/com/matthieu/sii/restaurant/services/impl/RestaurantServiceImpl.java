package com.matthieu.sii.restaurant.services.impl;

import com.matthieu.sii.restaurant.models.Restaurant;
import com.matthieu.sii.restaurant.services.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Override
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

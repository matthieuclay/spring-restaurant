package com.matthieu.sii.restaurant.services.impl;

import com.matthieu.sii.restaurant.models.Restaurant;
import com.matthieu.sii.restaurant.repository.RestaurantRepository;
import com.matthieu.sii.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurantList = new ArrayList<Restaurant>();

        restaurantRepository.findAll().forEach(restaurantList::add);

        return restaurantList;
    }

    @Override
    public Restaurant findById(String id) {
        if (restaurantRepository.findById(id).isPresent()) {
            return restaurantRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public String create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant).getId();
    }
}

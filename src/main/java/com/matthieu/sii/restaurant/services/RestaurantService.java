package com.matthieu.sii.restaurant.services;

import com.matthieu.sii.restaurant.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    public List<Restaurant> findAll();

    public Restaurant findById(String id);

    public String create(Restaurant restaurant);

    public void update(String id, Restaurant restaurant);

    public void partialUpdate(String id, Map<String, Object> updates);

    public void deleteById(String id);
}

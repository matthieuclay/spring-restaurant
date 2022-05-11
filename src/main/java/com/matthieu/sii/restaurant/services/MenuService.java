package com.matthieu.sii.restaurant.services;

import com.matthieu.sii.restaurant.models.Menu;

import java.util.Map;
import java.util.Set;

public interface MenuService {

    Set<Menu> findAll(String idRestaurant);

    Menu findById(String id);

    String create(String idRestaurant, Menu menu);

    void update(String id, Menu menu);

    void partialUpdate(String id, Map<String, Object> updates);

    void deleteById(String idRestaurant, String idMenu);
}

package com.matthieu.sii.restaurant.services;

import com.matthieu.sii.restaurant.models.Menu;

import java.util.Set;

public interface MenuService {

    public Set<Menu> findAll(String idRestaurant);

    public Menu findById(String id);
}

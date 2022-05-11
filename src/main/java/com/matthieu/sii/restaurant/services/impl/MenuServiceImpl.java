package com.matthieu.sii.restaurant.services.impl;

import com.matthieu.sii.restaurant.models.Menu;
import com.matthieu.sii.restaurant.models.Restaurant;
import com.matthieu.sii.restaurant.repository.MenuRepository;
import com.matthieu.sii.restaurant.repository.RestaurantRepository;
import com.matthieu.sii.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Set<Menu> findAll(String idRestaurant) {
        if (restaurantRepository.findById(idRestaurant).isPresent()) {
            return restaurantRepository.findById(idRestaurant).get().getMenus();
        }
        return null;
    }

    @Override
    public Menu findById(String id) {
        if (menuRepository.findById(id).isPresent()) {
            return menuRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public String create(String idRestaurant, Menu menu) {
        if (restaurantRepository.findById(idRestaurant).isPresent()) {
            Restaurant restaurant = restaurantRepository.findById(idRestaurant).get();
            restaurant.getMenus().add(menu);
            restaurantRepository.save(restaurant);
            return restaurant.getMenus().stream().filter(m -> m.equals(menu)).findFirst().get().getId();
        }
        return null;
    }

    @Override
    public void update(String id, Menu menu) {
        menu.setId(id);
        menuRepository.save(menu);
    }
}

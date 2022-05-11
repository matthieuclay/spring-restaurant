package com.matthieu.sii.restaurant.controllers;

import com.matthieu.sii.restaurant.models.Menu;
import com.matthieu.sii.restaurant.services.MenuService;
import com.matthieu.sii.restaurant.services.RestaurantService;
import com.matthieu.sii.restaurant.utils.CtrlPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants/{idRestaurant}/menus")
    public Set<Menu> findAll(@PathVariable("idRestaurant") String idRestaurant) {
        CtrlPreconditions.checkFound(restaurantService.findById(idRestaurant));
        return menuService.findAll(idRestaurant);
    }

    @GetMapping("/menus/{id}")
    public Menu findById(@PathVariable("id") String id) {
        CtrlPreconditions.checkFound(menuService.findById(id));
        return menuService.findById(id);
    }

}

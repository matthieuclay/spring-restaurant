package com.matthieu.sii.restaurant.controllers;

import com.matthieu.sii.restaurant.exceptions.NotFoundException;
import com.matthieu.sii.restaurant.models.Restaurant;
import com.matthieu.sii.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable String id) {
        Restaurant res = restaurantService.findById(id);

        if (res == null) {
            throw new NotFoundException();
        }

        return res;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }
}

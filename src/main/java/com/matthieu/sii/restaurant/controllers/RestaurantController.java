package com.matthieu.sii.restaurant.controllers;

import com.matthieu.sii.restaurant.models.Restaurant;
import com.matthieu.sii.restaurant.services.RestaurantService;
import com.matthieu.sii.restaurant.utils.CtrlPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        CtrlPreconditions.checkFound(res.getId());
        return res;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody Restaurant restaurant) {
        CtrlPreconditions.checkFound(id);
        restaurantService.update(id, restaurant);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        CtrlPreconditions.checkFound(id);
        restaurantService.partialUpdate(id, updates);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable String id) {
        CtrlPreconditions.checkFound(id);
        restaurantService.deleteById(id);
    }
}

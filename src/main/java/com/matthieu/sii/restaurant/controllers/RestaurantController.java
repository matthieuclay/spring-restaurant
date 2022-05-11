package com.matthieu.sii.restaurant.controllers;

import com.matthieu.sii.restaurant.models.Restaurant;
import com.matthieu.sii.restaurant.services.RestaurantService;
import com.matthieu.sii.restaurant.utils.CtrlPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
        List<Restaurant> restaurants = restaurantService.findAll();
        for (Restaurant restaurant : restaurants) {
            Link selfLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(restaurant.getId()).withSelfRel();
            restaurant.add(selfLink);
        }
        return restaurants;
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable String id) {
        Restaurant restaurant = restaurantService.findById(id);
        CtrlPreconditions.checkFound(restaurant);
        Link menusLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(restaurant.getId()).slash("menus").withRel("menus");
        restaurant.add(menusLink);
        return restaurant;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody Restaurant restaurant) {
        CtrlPreconditions.checkFound(restaurantService.findById(id));
        restaurantService.update(id, restaurant);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        CtrlPreconditions.checkFound(restaurantService.findById(id));
        restaurantService.partialUpdate(id, updates);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable String id) {
        CtrlPreconditions.checkFound(restaurantService.findById(id));
        restaurantService.deleteById(id);
    }
}

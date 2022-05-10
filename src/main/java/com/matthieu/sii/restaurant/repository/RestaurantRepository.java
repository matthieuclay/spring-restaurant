package com.matthieu.sii.restaurant.repository;

import com.matthieu.sii.restaurant.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}

package com.matthieu.sii.restaurant.repository;

import com.matthieu.sii.restaurant.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, String> {
}

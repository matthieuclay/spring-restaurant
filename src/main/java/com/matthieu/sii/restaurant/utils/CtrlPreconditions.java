package com.matthieu.sii.restaurant.utils;

import com.matthieu.sii.restaurant.exceptions.NotFoundException;

public final class CtrlPreconditions {

    public static void checkFound(String restaurantId) {
        if (restaurantId == null) {
            throw new NotFoundException();
        }
    }

}

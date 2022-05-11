package com.matthieu.sii.restaurant.utils;

import com.matthieu.sii.restaurant.exceptions.NotFoundException;

public final class CtrlPreconditions {

    public static <T> void checkFound(T object) {
        if (object == null) {
            throw new NotFoundException();
        }
    }

}

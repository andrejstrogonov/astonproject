package org.astonlearning.quiclsortapplication.validation;

import org.astonlearning.quiclsortapplication.Car;

public class ValidationUtil {
    public static boolean isValid(Car car) {
        if (car == null) {
            return false;
        }

        if (car.getModel() == null || car.getModel().trim().isEmpty()) {
            return false;
        }

        if (car.getPower() < 0) {
            return false;
        }

        if (car.getProductionYear() < 1900 || car.getProductionYear() > 2026) {
            return false;
        }

        return true;
    }
}

package org.astonlearning.quiclsortapplication.validation;

import org.astonlearning.quiclsortapplication.Car;

public class ValidationUtil {
    private static final int MIN_YEAR = 1886;
    private static final int MAX_YEAR = 2026;

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

        if (car.getProductionYear() < MIN_YEAR || car.getProductionYear() > MAX_YEAR) {
            return false;
        }

        return true;
    }
}

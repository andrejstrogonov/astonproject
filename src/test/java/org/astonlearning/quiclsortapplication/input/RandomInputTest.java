package org.astonlearning.quiclsortapplication.input;

import java.util.List;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.validation.ValidationUtil;

public class RandomInputTest {
    public static void main(String[] args) {
        int size = 10;

        InputProvider input = new RandomInput(size);

        List<Car> cars = input.load();

        System.out.println("Expected size: " + size);
        System.out.println("Actual size: " + cars.size());

        if (cars.size() != size) {
            System.out.println("FAIL: wrong size");
            return;
        }

        for (Car car : cars) {
            if (!ValidationUtil.isValid(car)) {
                System.out.println("FAIL: invalid car found");
                return;
            }
        }

        System.out.println("PASS");
    }
}

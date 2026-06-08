package org.astonlearning.quiclsortapplication.input;

import java.util.List;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.validation.ValidationUtil;

public class FileInputTest {
    public static void main(String[] args) {
        String path = "src/test/resources/cars.txt";

        InputProvider input = new FileInput(path, 2);

        List<Car> cars = input.load();

        System.out.println("Expected size <= 2");
        System.out.println("Actual size: " + cars.size());

        if (cars.size() > 2) {
            System.out.println("FAIL: size limit broken");
            return;
        }

        for (Car car : cars) {
            if (!ValidationUtil.isValid(car)) {
                System.out.println("FAIL: invalid car passed validation");
                return;
            }

            System.out.println(car);
        }

        System.out.println("PASS");
    }
}

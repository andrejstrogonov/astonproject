package org.astonlearning.quiclsortapplication.input;

import java.util.List;
import java.util.Scanner;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.validation.ValidationUtil;

public class ManualInputTest {
    public static void main(String[] args) {
        String simulatedInput =
         "100 BMW 2010\n" +
         "200 Audi 2015\n" +
         "abc\n" +
         "300 Toyota 2020\n" +
         "100 BMW 1800\n";

         Scanner scanner = new Scanner(simulatedInput);

         InputProvider input = new ManualInput(scanner, 3);

         List<Car> cars = input.load();

         System.out.println("Result size: " + cars.size());

         for (Car car : cars) {
            if (!ValidationUtil.isValid(car)) {
                System.out.println("FAIL: invalid car");
                return;
            }
         }

         System.out.println("PASS");
    }
}

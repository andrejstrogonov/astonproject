package org.astonlearning.quiclsortapplication.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.validation.ValidationUtil;

public class ManualInput implements InputProvider {
    private final Scanner scanner;
    private final int size;

    public ManualInput(Scanner scanner, int size) {
        this.scanner = scanner;
        this.size = size;
    }

    @Override
    public List<Car> load() {
        List<Car> cars = new ArrayList<>();

        IntStream.range(0, size)
                .mapToObj(i -> readCar())
                .filter(ValidationUtil::isValid)
                .forEach(cars::add);

        return cars;
    }

    private Car readCar() {
        try {
            System.out.println("Enter car data (power, model, year)");

            int power = scanner.nextInt();
            String model = scanner.next();
            int year = scanner.nextInt();

            return new Car(power, model, year);
        } catch (Exception e) {
            scanner.nextLine();
            return null;
        }
    }
}

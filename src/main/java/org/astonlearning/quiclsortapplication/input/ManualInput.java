package org.astonlearning.quiclsortapplication.input;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.customcollection.CustomArrayList;
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
        List<Car> cars = new CustomArrayList<>();

        Stream.generate(this::readCar)
                    .filter(ValidationUtil::isValid)
                    .limit(size)
                    .forEach(cars::add); 

        return cars;
    }

    private Car readCar() {
        try {
            System.out.println("Enter car data (power, model, year)");

            int power = scanner.nextInt();
            String model = scanner.next();
            int year = scanner.nextInt();

            return new Car.Builder().setPower(power).setModel(model).setProductionYear(year).build();
            
        } catch (Exception e) {
            scanner.nextLine();
            return null;
        }
    }
}

package org.astonlearning.quiclsortapplication.output;

import java.util.List;

import org.astonlearning.quiclsortapplication.Car;

public class ConsoleOutput implements OutputProvider {
    @Override
    public void output(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars found");
            return;
        }

        cars.forEach(System.out::println);
    }
}

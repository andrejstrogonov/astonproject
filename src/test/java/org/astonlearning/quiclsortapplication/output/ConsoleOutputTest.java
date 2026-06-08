package org.astonlearning.quiclsortapplication.output;

import java.util.List;

import org.astonlearning.quiclsortapplication.Car;

public class ConsoleOutputTest {
    public static void main(String[] args) {
        OutputProvider output = new ConsoleOutput();

        List<Car> cars = List.of(
            new Car(100, "BMW", 2010),
            new Car(200, "Audi", 2015),
            new Car(300, "Toyota", 2020)
        );

        System.out.println("=== TEST 1: normal list ===");
        output.output(cars);

        System.out.println("=== TEST 2: empty list ===");
        output.output(List.of());

        System.out.println("\nPASS");
    }
}

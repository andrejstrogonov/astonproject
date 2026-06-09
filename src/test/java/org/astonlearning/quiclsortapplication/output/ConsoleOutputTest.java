package org.astonlearning.quiclsortapplication.output;

import java.util.List;

import org.astonlearning.quiclsortapplication.Car;

public class ConsoleOutputTest {
    public static void main(String[] args) {
        OutputProvider output = new ConsoleOutput();

        List<Car> cars = List.of(
            new Car.Builder().setPower(100).setModel("BMW").setProductionYear(2010).build(),
            new Car.Builder().setPower(200).setModel("Audi").setProductionYear(2015).build(),
            new Car.Builder().setPower(300).setModel("Toyota").setProductionYear(2020).build()
        );

        System.out.println("=== TEST 1: normal list ===");
        output.output(cars);

        System.out.println("=== TEST 2: empty list ===");
        output.output(List.of());

        System.out.println("\nPASS");
    }
}

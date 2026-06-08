package org.astonlearning.quiclsortapplication.output;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.astonlearning.quiclsortapplication.Car;

public class FileOutputTest {
    public static void main(String[] args) {
        String path = "src/test/resources/output-test.txt";

        OutputProvider output = new FileOutput(path);

        List<Car> cars = List.of(
            new Car(100, "BMW", 2010),
            new Car(200, "Audi", 2015),
            new Car(300, "Toyota", 2020)
        );

        System.out.println("Writing to file");

        output.output(cars);

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("FAIL: file not created");
            return;
        }

        if (file.length() == 0) {
            System.out.println("FAIL: file is empty");
            return;
        }

        try {
            System.out.println("File content:");
            Files.lines(file.toPath()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("FAIL: cannot read file");
            return;
        }

        System.out.println("PASS");
    }
}

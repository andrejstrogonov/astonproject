package org.astonlearning.quiclsortapplication.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.validation.ValidationUtil;

public class FileInput implements InputProvider {
    private final String filePath;
    private final int size;

    public FileInput(String filePath, int size) {
        this.filePath = filePath;
        this.size = size;
    }

    @Override
    public List<Car> load() {
        try {
            return Files.lines(Path.of(filePath))
                        .map(this::parseCar)
                        .filter(ValidationUtil::isValid)
                        .limit(size)
                        .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    private Car parseCar(String line) {
        try {
            String[] parts = line.trim().split("\\s+");

            if (parts.length != 3) {
                return null;
            }

            int power = Integer.parseInt(parts[0]);
            String model = parts[1];
            int year = Integer.parseInt(parts[2]);

            return new Car.Builder().setPower(power).setModel(model).setProductionYear(year).build();

        } catch (NumberFormatException e) {
            return null;
        }
    }
}

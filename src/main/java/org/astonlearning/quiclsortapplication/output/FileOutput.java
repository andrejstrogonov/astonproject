package org.astonlearning.quiclsortapplication.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.astonlearning.quiclsortapplication.Car;

public class FileOutput implements OutputProvider{
    private final String filePath;

    public FileOutput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void output(List<Car> cars) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Car car : cars) {
                writer.write(car.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file", e);
        }
    }
}

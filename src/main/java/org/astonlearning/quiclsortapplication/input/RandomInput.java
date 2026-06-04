package org.astonlearning.quiclsortapplication.input;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.validation.ValidationUtil;

public class RandomInput implements InputProvider{
    private final int size;
    private final Random random = new Random();

    public RandomInput(int size) {
        this.size = size;
    }

    @Override
    public List<Car> load() {
        return Stream.generate(this::generateCar)
                    .filter(ValidationUtil::isValid)
                    .limit(size)
                    .collect(Collectors.toList());
    }

    private Car generateCar() {
        return new Car(generatePower(), generateModel(), generateYear());
    }

    private int generatePower() {
        return random.nextInt(400) + 50;
    }

    private int generateYear() {
        return random.nextInt(27) + 2000;
    }

    private String generateModel() {
        String[] models = {
            "BMW",
            "Audi",
            "Mercedes",
            "Toyota",
            "Honda",
            "Nissan",
            "Ford",
            "Kia",
            "Ferrari",
            "Porsche"
        };

        return models[random.nextInt(models.length)];
    }
}

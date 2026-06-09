package org.astonlearning.quiclsortapplication.input;

import java.util.List;

import org.astonlearning.quiclsortapplication.Car;

public interface InputProvider {
    List<Car> load();
}

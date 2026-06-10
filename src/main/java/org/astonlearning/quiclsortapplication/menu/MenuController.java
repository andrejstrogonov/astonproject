package org.astonlearning.quiclsortapplication.menu;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.input.FileInput;
import org.astonlearning.quiclsortapplication.input.InputProvider;
import org.astonlearning.quiclsortapplication.input.ManualInput;
import org.astonlearning.quiclsortapplication.input.RandomInput;
import org.astonlearning.quiclsortapplication.multithreading.ElementCounter;
import org.astonlearning.quiclsortapplication.output.ConsoleOutput;
import org.astonlearning.quiclsortapplication.output.FileOutput;
import org.astonlearning.quiclsortapplication.output.OutputProvider;
import org.astonlearning.quiclsortapplication.sorting.SortType;
import org.astonlearning.quiclsortapplication.sorting.SortingManager;

public class MenuController {
    private final Scanner scanner = new Scanner(System.in);
    private final SortingManager sortingManager = new SortingManager();

    private List<Car> cars;
    private InputProvider currentInput;

    public void run() {
        while (true) {
            printMenu();

            int choice = readInt();

            switch (choice) {
                case 1:
                    loadData();
                    // showData();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    sortData();
                    // showData();
                    break;
                case 4:
                    countElement();
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Load data");
        System.out.println("2. Show data");
        System.out.println("3. Sort data");
        System.out.println("4. Count element occurrences (multithreaded)");
        System.out.println("0. Exit");
        System.out.println("Choose: ");
    }

    private void loadData() {
        currentInput = chooseInput();
        cars = currentInput.load();
        System.out.println("Data loaded: " + cars.size() + " cars");
    }

    private void showData() {
        if (cars == null || cars.isEmpty()) {
            System.out.println("No data loaded");
            return;
        }

        OutputProvider output = chooseOutput();
        output.output(cars);
    }

    private void sortData() {
        if (cars == null || cars.isEmpty()) {
            System.out.println("No data to sort");
            return;
        }

        System.out.println("\nChoose sort option:");
        System.out.println("1. Default sort");
        System.out.println("2. Sort by field");
        System.out.println("3. Sort by field + filter (even year)");

        int choice = readInt();

        switch (choice) {
            case 1:
                sortingManager.executeSort(cars);
                break;
            case 2:
                sortByField();
                break;
            case 3:
                sortWithFilter();
                break;
            default:
                System.out.println("Invalid option");
                return;
        }

        System.out.println("Sorted successfully");

    }

    private void sortByField() {
        System.out.println("Choose field:");
        System.out.println("1. Model");
        System.out.println("2. Year");
        System.out.println("3. Power");

        int choice = readInt();

        switch (choice) {
            case 1:
                sortingManager.executeSort(cars, SortType.MODEL);
                break;
            case 2:
                sortingManager.executeSort(cars, SortType.YEAR);
                break;
            case 3:
                sortingManager.executeSort(cars, SortType.POWER);
                break;
            default:
                System.out.println("Invalid field");
        }
    }

    private void sortWithFilter() {
        System.out.println("Choose field:");
        System.out.println("1. Model");
        System.out.println("2. Year");
        System.out.println("3. Power");

        int choice = readInt();

        Predicate<Car> filter = car -> car.getProductionYear() % 2 == 0;

        switch (choice) {
            case 1:
                sortingManager.executeSort(cars, SortType.MODEL, filter);
                break;
            case 2:
                sortingManager.executeSort(cars, SortType.YEAR, filter);
                break;
            case 3:
                sortingManager.executeSort(cars, SortType.POWER, filter);
                break;
            default:
                System.out.println("Invalid field");
        }
    }

    private void countElement() {
        if (cars == null || cars.isEmpty()) {
            System.out.println("No data loaded");
            return;
        }

        System.out.println("\nChoose field:");
        System.out.println("1. Model");
        System.out.println("2. Year");
        System.out.println("3. Power");

        int choice = readInt();

        System.out.print("Enter value to count: ");
        String value = scanner.nextLine().trim();

        if (value.isBlank()) {
            System.out.println("Value cannot be empty");
            return;
        }

        List<String> data;

        switch (choice) {
            case 1:
                data = cars.stream()
                    .map(Car::getModel)
                    .collect(Collectors.toList());
                break;

            case 2:
                data = cars.stream()
                    .map(car -> String.valueOf(car.getProductionYear()))
                    .collect(Collectors.toList());
                break;

            case 3:
                data = cars.stream()
                    .map(car -> String.valueOf(car.getPower()))
                    .collect(Collectors.toList());
                break;

            default:
                System.out.println("Invalid option");
                return;
        }

        int count = ElementCounter.countElement(data, value);

        System.out.println("Occurrences: " + count);
    }
    
    private OutputProvider chooseOutput() {
        while (true) {
            System.out.println("\nChoose output type:");
            System.out.println("1. Console");
            System.out.println("2. File");
    
            int choice = readInt();
    
            switch (choice) {
                case 1:
                    return new ConsoleOutput();
                case 2:
                    String path = readOutputFilePath();
                    return new FileOutput(path);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private InputProvider chooseInput() {        
        while (true) {
            System.out.println("\nChoose input type:");
            System.out.println("1. Random");
            System.out.println("2. Manual");
            System.out.println("3. File");

            int choice = readInt();
    
            switch (choice) {
                case 1:
                    return new RandomInput(readSize());
                case 2:
                    return new ManualInput(scanner, readSize());
                case 3:
                    String path = readInputFilePath();
                    int size = readSize();
                    return new FileInput(path, size);
                default:
                    System.out.println("Invalid option. Please try again:");
                }
        }

    }

    private String readInputFilePath() {
        while (true) {
            System.out.print("File path: ");
            String path = scanner.nextLine().trim();

            if (path == null || path.isBlank()) {
                System.out.println("Path cannot be empty. Try again");
                continue;
            }

            File file = new File(path);

            if (!file.exists() || !file.isFile()) {
                System.out.println("File does not exist. Try again.");
                continue;
            }

            return path;
        }
    }

    private String readOutputFilePath() {
        while (true) {
            System.out.print("Enter output file path: ");
            String path = scanner.nextLine().trim();

            if (path.isBlank()) {
                System.out.println("Path cannot be empty. Try again");
                continue;
            }

            return path;
        }
    }

    private int readSize() {
        System.out.println("Enter size: ");
        int size = readInt();

        while (size <= 0) {
            System.out.println("Size must be > 0. Try again:");
            size = readInt();
        }

        return size;
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Enter number!");
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}

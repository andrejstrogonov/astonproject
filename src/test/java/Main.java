import org.astonlearning.quiclsortapplication.sorting.SortType;
import org.astonlearning.quiclsortapplication.sorting.SortingManager;

import java.util.List;

public class Main {
    package org.astonlearning.quiclsortapplication.test;

import org.astonlearning.quiclsortapplication.sorting.SortType;
import org.astonlearning.quiclsortapplication.sorting.SortingManager;

import java.util.List;

    public class Main {
        public static void main(String[] args) {
            Car car1 = new Car(650, "ZEEKR", 2025);
            Car car2 = new Car(500, "AUDI", 2011);
            Car car3 = new Car(200, "BMW", 2020);
            Car car4 = new Car(150, "NISSAN", 2014);

            List<Car> carsList = new CustomArrayList<>();
            carsList.add(car1);
            carsList.add(car2);
            carsList.add(car3);
            carsList.add(car4);

            SortingManager manager = new SortingManager();



            System.out.println("Исходная коллекия" + carsList);
            System.out.println("\n =============================== \n");

            manager.executeSort(carsList); // дефолт сортировка по 3 полям

            System.out.println("Коллекчия после дефотной сортировки" + carsList);

            System.out.println("=========================================");

            manager.executeSort(carsList, SortType.MODEL);

            System.out.println("Сортировка по модели " + carsList);

            manager.executeSort(carsList, SortType.YEAR, car -> car.getProductionYear() % 2 == 0 );
            System.out.println("\n=================================\n");

            System.out.println("Сортировка для доп задания 1" + carsList);


        }
    }

}

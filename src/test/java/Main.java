import org.astonlearning.quiclsortapplication.Car;
import org.astonlearning.quiclsortapplication.customcollection.CustomArrayList;
import org.astonlearning.quiclsortapplication.multithreading.ElementCounter;
import org.astonlearning.quiclsortapplication.sorting.SortType;
import org.astonlearning.quiclsortapplication.sorting.SortingManager;

import java.util.List;

public class Main {

        public static void main(String[] args) {

            List<Car> carsList = new CustomArrayList<>();
            carsList.add(new Car.Builder().setModel("ZEEKR").setPower(550).setProductionYear(2021).build());
            carsList.add(new Car.Builder().setModel("AUDI").setPower(500).setProductionYear(2011).build());
            carsList.add(new Car.Builder().setModel("BMW").setPower(200).setProductionYear(2020).build());
            carsList.add(new Car.Builder().setModel("NISSAN").setPower(150).setProductionYear(2014).build());
            carsList.add(new Car.Builder().setModel("ZEEKR").setPower(550).setProductionYear(2021).build());
            carsList.add(new Car.Builder().setModel("ZEEKR").setPower(550).setProductionYear(2021).build());
            carsList.add(new Car.Builder().setModel("ZEEKR").setPower(550).setProductionYear(2021).build());

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

            // тест потока
            System.out.println("\n=================================\n");
            Car carToFind = new Car.Builder().setModel("ZEEKR").setPower(550).setProductionYear(2021).build();
          int res = ElementCounter.countElement(carsList, carToFind);

        }
    }



package org.astonlearning.quiclsortapplication.multithreading;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ElementCounter {

    private ElementCounter() {}
    /*
     countOccurrencesMultithreaded Возвращает int для удобного тестирования, а результат выводит в консоль по ТЗ.
     */
    public static  <T> int countElement(List<T> collection, T element) {

        if (collection == null || collection.isEmpty()) {
            System.out.println("Передана пустая коллекция. Количество вхождений элемента: " +  element + "---> 0");
            return 0;
        }

        // Потокобезопасная переменная для записи результата подсчета
        AtomicInteger totalCount = new AtomicInteger(0);

        // делим колекцию на 2 части для разделения задач между потоками
        int mid = collection.size() / 2;

        // первый поток ищет от начала до середины
        Thread thread1 = new Thread(() -> {
            int count = 0;
            for (int i = 0; i < mid; i++) {
                T currentElem = collection.get(i);
                if (currentElem != null && currentElem.equals(element)) {
                    count++;
                }
            }
            totalCount.addAndGet(count); // скидываем результат в общую переменную
        });

        Thread thread2 = new Thread(() -> {
            int count = 0;
            for (int i = mid; i < collection.size(); i++) {
                T currentElem = collection.get(i);
                if (currentElem != null && currentElem.equals(element)) {
                    count++;
                }
            }
            totalCount.addAndGet(count);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.out.println("Количество вхождения элемента " + element + "====>>> " + totalCount.get());
        return totalCount.get();
    }

}

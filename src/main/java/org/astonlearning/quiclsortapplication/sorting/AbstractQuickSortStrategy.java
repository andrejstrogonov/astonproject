package org.astonlearning.quiclsortapplication.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

abstract class AbstractQuickSortStrategy<T> implements SortingStrategy<T> {

    protected abstract int compare(T o1, T o2);

    @Override
    public void sort(List<T> list, Predicate<T> filter) {
        if (list == null || list.size() <= 1) {
            return;
        }
//забираем элементы, которые подходят под фильтр
        if (filter != null) {
            List<T> filteredItems = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                T item = list.get(i);
                if (filter.test(item)) {
                    filteredItems.add(item);
                }
            }

            // Сортируем собранные элементы квиксортом
            if (filteredItems.size() > 1) {
                runQuickSort(filteredItems, 0, filteredItems.size() - 1);
            }

            // идем заново по исходному списку.
            // Если элемент подходит под фильтр — перезаписываем его из .filteredItems
            int counter = 0;
            for (int i = 0; i < list.size(); i++) {
                if (filter.test(list.get(i))) {
                    list.set(i, filteredItems.get(counter));
                    counter++; // Двигаем указатель на следующий отсортированный элемент
                }
            }
        } else {
            runQuickSort(list, 0, list.size() - 1);
        }
    }

    // Рекурсивный запуск квиксорта
    private void runQuickSort(List<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            runQuickSort(list, low, pivotIndex - 1);
            runQuickSort(list, pivotIndex + 1, high);
        }
    }

    // Разделение массива (опорный элемент берем посередине и кидаем в конец)
    private int partition(List<T> list, int low, int high) {
        int mid = low + (high - low) / 2;
        swap(list, mid, high);

        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    // обмен элементов местами через временную переменную
    private void swap(List<T> list, int i, int j) {
        if (i == j) return;
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
package org.astonlearning.quiclsortapplication.sorting;

/*
 Стратегия сортировки автомобилей по умолчанию.
  Использует сравнение, заложенное изначально в метод compareTo класса Car
  (по мощности -> по модели -> по году выпуска).
 */
 final class DefaultSortStrategy extends AbstractQuickSortStrategy<Car> {

    @Override
    protected int compare(Car o1, Car o2) {
        return o1.compareTo(o2);
    }
}

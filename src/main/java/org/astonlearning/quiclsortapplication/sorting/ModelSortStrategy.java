package org.astonlearning.quiclsortapplication.sorting;

/*
  Стратегия сортировки автомобилей по их модели в алфавитном порядке
 */

import org.astonlearning.quiclsortapplication.Car;

final class ModelSortStrategy extends AbstractQuickSortStrategy<Car> {

    @Override
    protected int compare(Car o1, Car o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}

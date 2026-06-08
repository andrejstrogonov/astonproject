package org.astonlearning.quiclsortapplication.sorting;

/*
 *Стратегия сортировки автомобилей по мощности
 */

 final class PowerSortStrategy extends AbstractQuickSortStrategy<Car> {

    @Override
    protected int compare(Car o1, Car o2) {
      return Integer.compare(o1.getPower(), o2.getPower());
    }
}

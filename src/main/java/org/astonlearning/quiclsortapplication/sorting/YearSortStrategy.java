package org.astonlearning.quiclsortapplication.sorting;

/*
  Стратегия сортировки автомобилей по году выпуска
 */

 final class YearSortStrategy extends AbstractQuickSortStrategy<Car> {

    @Override
    protected int compare(Car o1, Car o2) {
        return Integer.compare(o1.getProductionYear(), o2.getProductionYear());
    }
}

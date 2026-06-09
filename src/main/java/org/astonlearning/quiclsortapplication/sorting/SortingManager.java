package org.astonlearning.quiclsortapplication.sorting;

import org.astonlearning.quiclsortapplication.Car;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SortingManager {
    private final Map<SortType, SortingStrategy<Car>> strategies;

    public SortingManager() {
        strategies = new EnumMap<>(SortType.class);
        strategies.put(SortType.DEFAULT, new DefaultSortStrategy());
        strategies.put(SortType.POWER, new PowerSortStrategy());
        strategies.put(SortType.YEAR, new YearSortStrategy());
        strategies.put(SortType.MODEL, new ModelSortStrategy());
    }

    /*
      1) Основной метод сортировки.
     */

    public void executeSort(List<Car> list, SortType type, Predicate<Car> filter) {
        SortType actualType = (type != null) ? type : SortType.DEFAULT;
        SortingStrategy<Car> strategy = strategies.get(actualType);
        strategy.sort(list, filter);
    }

    /*
      2. Только тип сортировки (без фильтра).
     */

    public void executeSort(List<Car> list, SortType type) {
        executeSort(list, type, null);
    }


    /*
      3. УЛЬТРА-КОРОТКИЙ ВАРИАНТ: Вообще без параметров.
      Просто сортирует по дефолту весь список.
     */
    public void executeSort(List<Car> list) {
        executeSort(list, SortType.DEFAULT, null);
    }

    /*
      4. на случай добавления новых полей для фильтрации чтоб не надо было переписывать ENUM(SORTTYPE)
            есть вохможность напрямую его запихнуть в параметр метода
     */
    public void executeSort(List<Car> list, SortingStrategy<Car> strategy) {
        if (strategy != null) {
            strategy.sort(list);
        }
    }
}

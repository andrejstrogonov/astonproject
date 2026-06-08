package org.astonlearning.quiclsortapplication.sorting;

import java.util.List;
import java.util.function.Predicate;

/**
 * @param <T> тип элементов, которые будут сортироваться чтоб не было жесткой привязки к классу Car
 */
public interface SortingStrategy<T> {
    /*
      Основной метод сортировки коллекции с возможностью фильтрации элементов.
      Элементы, не прошедшие фильтр, остаются на своих местах.

     */
    void sort(List<T> list, Predicate<T> filter);

    /*
     * Перегруженный метод для стандартной сортировки всей коллекции без условий.
     */
    default void sort(List<T> list) {
        sort(list, null);
    }
}

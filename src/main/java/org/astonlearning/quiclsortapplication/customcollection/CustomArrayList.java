package org.astonlearning.quiclsortapplication.customcollection;

import java.util.AbstractList;

/**
 * Список элементов. При добавлении саморасширяется
 * 
 * @author Мазур Егор
 * @version 1.0
 * @param <T> тип элементов, хранящихся в этом списке
 */
public class CustomArrayList<T> extends AbstractList<T> {
    /** Массив храник элементы коллекции */
    private Object[] elements;
    /** Размер коллекции */
    private int size;

    /** Создает пустую коллекцию с размером 10 */
    public CustomArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    /**
     * Возвращает текущее количество элементов в списке
     *
     * @return число элементов в этом списке
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Возвращает элемент по указанному индексу
     *
     * @param index индекс запрашиваемого элемента
     * @return элемент, находящийся на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона от
     *                                   0 до size - 1
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Добавляет элемент в конец списка. Если внутренний массив заполнен,
     * его емкость автоматически увеличивается
     *
     * @return {@code true} успешное добавление элемента.
     * @param element элемент, который необходимо добавить в список
     */
    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            int newArraySize = elements.length + (elements.length / 2);

            Object[] newElements = new Object[newArraySize];

            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }
        
        elements[size] = element;
        size++;
        /** Увеличиваем счетчик изменеий */
        modCount++;

        return true;
    }

    /**
     * Добавляет элемент в конец списка. Если внутренний массив заполнен,
     * его емкость автоматически увеличивается
     *
     * @return {@code true} успешное добавление элемента.
     * @param element элемент, который необходимо добавить в список
     */
    @Override
    public T remove(int index) {
        checkIndex(index);

        T oldValue = (T) elements[index];
        int elementsToMove = size - index - 1;

        if (elementsToMove > 0) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
        }

        size--;
        elements[size] = null;
        /** Увеличиваем счетчик изменеий */
        modCount++;

        return oldValue;
    }

    /**
     * Заменяет элемент в указанной позиции списка новым элементом
     *
     * @param index   индекс изменяемого элемента
     * @param element элемент, который будет сохранен в указанной позиции
     * @return старое значение элемента, находившееся на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона
     */
    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        checkIndex(index);
        T oldValue = (T) elements[index];
        elements[index] = element;
        return oldValue;
    }

    /**
     * Метод проверяет находится элемент в размере массива, или нет
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Element index: " + index + ", Array size: " + size);
        }
    }
}

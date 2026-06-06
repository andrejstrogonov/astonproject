package org.astonlearning.quiclsortapplication.customcollection;

/**
 * Список элементов. При добавлении саморасширяется.
 * @author Мазур Егор
 * @version 1.0
 * @param <T> тип элементов, хранящихся в этом списке.
 */
public class CustomArrayList<T> {
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
     * Возвращает текущее количество элементов в списке.
     *
     * @return число элементов в этом списке
     */
    public int size() {
        return this.size;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс запрашиваемого элемента
     * @return элемент, находящийся на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона от
     *                                   0 до size - 1
     */
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Добавляет элемент в конец списка. Если внутренний массив заполнен,
     * его емкость автоматически увеличивается.
     *
     * @param element элемент, который необходимо добавить в список
     */
    public void add(T element) {
        if (size == elements.length) {
            int newArraySize = elements.length + (elements.length / 2);

            Object[] newElements = new Object[newArraySize];

            // Ручной перенос элементов
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }
        elements[size] = element;
        size++;
    }

    /**
     * Заменяет элемент в указанной позиции списка новым элементом.
     *
     * @param index   индекс изменяемого элемента
     * @param element элемент, который будет сохранен в указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона от
     *                                   0 до size - 1
     */
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    /**
     * Метод проверяет находится элемент в размере массива, или нет.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Element index: " + index + ", Array size: " + size);
        }
    }
}

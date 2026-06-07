package org.astonlearning.quiclsortapplication;

import java.util.Comparator;

/**
 * Класс - сущность автомобиля.
 * 
 * Для создания экземпляров класса используется {@link Builder}.
 * </p>
 * 
 * @author Мазур Егор
 * @version 1.0
 * @since 2026-06-03
 */
public class Car implements Comparable<Car> {
    /** Паименование марки автомобиля. */
    private String model;
    /** Мощность автомобиля в лошадиных силах. */
    private int power;
    /** Год производства автомобиля. */
    private int year;

    public Car(int power, String model, int year){
        this.model = model;
        this.power = power;
        this.year = year;
    }

    /**
     * Конструктор для инициализации объекта через билдер.
     *
     * @param builder экземпляр строителя, содержащий параметры автомобиля.
     */
    public Car(Builder builder) {
        this.model = builder.model;
        this.power = builder.power;
        this.year = builder.year;
    }

    /** @return марка автомобиля */
    public String getModel() {
        return model;
    }

    /** @return мощность в лошадиных силах */
    public int getPower() {
        return power;
    }

    /** @return год производства автомобиля */
    public int getProductionYear() {
        return year;
    }

    /** @return строковое представления автомобиля {@code Car} */
    @Override
    public String toString() {
        return String.format("Car{model='%s', power=%d л.с., year=%d}", model, power, year);
    }

    /** Вложенный класс, для пошагового создания экземпляров класса {@link Car}. */
    public static class Builder {
        private String model;
        private int power;
        private int year;

        /**
         * @param model название модели автомобиля
         * @return экземпляр строителя для цепочки вызовов
         */
        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * @param power мощность в лошадиных силах
         * @return экземпляр строителя для цепочки вызовов
         */
        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        /**
         * @param power год выпуска автомобиля
         * @return экземпляр строителя для цепочки вызовов
         */
        public Builder setProductionYear(int year) {
            this.year = year;
            return this;
        }

        /**
         * Создает и возвращает готовый объект класса {@link Car}
         * на основе переданных параметров.
         *
         * @return новый объект {@link Car}
         */
        public Car build() {
            return new Car(this);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>
     * Сравнивает текущий экземпляр класса {@code Car} с указанным объектом на
     * равенство.
     * Два объекта класса {@code Car} считаются равными тогда и только тогда,
     * когда совпадают их мощность, модель и год производства.
     * </p>
     *
     * @param obj объект для сравнения с текущим автомобилем
     * @return {@code true}, если указанный объект равен данному автомобилю
     *         {@code Car};
     *         {@code false} если объекты не равны
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Car car = (Car) o;

        if (this.power != car.power) return false;
        if (this.year != car.year) return false;
        return this.model != null ? this.model.equals(car.model) : car.model == null;
    }

    /**
     * {@inheritDoc}
     * 
     * <p>
     * Возвращает значение хэш-кода для автомобиля. Хэш-код генерируется
     * на основе всех полей класса (мощность, модель, год производства),
     * что обеспечивает выполнение общего контракта: у равных объектов
     * по методу {@link #equals(Object)} всегда будут одинаковые хэш-коды.
     * </p>
     *
     * @return целое число, представляющее хэш-код данного объекта
     * @see Object#hashCode()
     * @see #equals(Object)
     */
    @Override
    public int hashCode() {
        int result = (model != null ? model.hashCode() : 0);
        result = 31 * result + power;
        result = 31 * result + year;
        return result;
    }

    @Override
    public int compareTo(Car otherCar) {
        if (otherCar == null) {
        throw new NullPointerException("Сравниваемый объект не может быть null");
    }

        return Comparator.comparing(Car::getModel, String.CASE_INSENSITIVE_ORDER)
                .thenComparingInt(Car::getPower)
                .thenComparingInt(Car::getProductionYear)
                .compare(this, otherCar);
    }
}

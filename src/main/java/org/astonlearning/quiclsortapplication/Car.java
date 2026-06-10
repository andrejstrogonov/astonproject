package org.astonlearning.quiclsortapplication;

import java.util.Comparator;

/**
 * Класс - сущность автомобиля
 * 
 * Для создания экземпляров класса используется {@link Builder}
 * </p>
 * 
 * @author Мазур Егор
 * @version 1.0
 * @since 2026-06-03
 */
public class Car implements Comparable<Car> {
    /** Наименование марки автомобиля */
    private final String model;
    /** Мощность автомобиля в лошадиных силах */
    private final int power;
    /** Год производства автомобиля */
    private final int productionYear;
    /** Компаратор для сравнения экземпляров */
    private static final Comparator<Car> CAR_COMPARATOR = Comparator
            .comparing(Car::getModel, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)) 
            .thenComparingInt(Car::getPower)
            .thenComparingInt(Car::getProductionYear);

    /**
     * Конструктор для инициализации объекта через билдер
     *
     * @param builder экземпляр строителя, содержащий параметры автомобиля
     */
    public Car(Builder builder) {
        this.model = builder.model;
        this.power = builder.power;
        this.productionYear = builder.productionYear;
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
        return productionYear;
    }

    /** @return строковое представления автомобиля {@code Car} */
    @Override
    public String toString() {
        return String.format("Car{model='%s', power=%d л.с., year=%d}", model, power, productionYear);
    }

    /** Вложенный класс, для пошагового создания экземпляров класса {@link Car} */
    public static class Builder {
        private String model;
        private int power;
        private int productionYear;

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
         * @param productionYear год выпуска автомобиля
         * @return экземпляр строителя для цепочки вызовов
         */
        public Builder setProductionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        /**
         * Создает и возвращает готовый объект класса {@link Car}
         * на основе переданных параметров
         *
         * @return новый объект {@link Car}
         */
        public Car build() {
            return new Car(this);
        }
    }

    /**
     * Сравнивает текущий экземпляр класса {@code Car} с указанным объектом на
     * равенство
     *
     * @param obj объект для сравнения с текущим автомобилем
     * @return {@code true}, если указанный объект равен данному автомобилю
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Car car = (Car) o;

        if (this.power != car.power)
            return false;
        if (this.productionYear != car.productionYear)
            return false;
        return this.model != null ? this.model.equalsIgnoreCase(car.model) : car.model == null;
    }

    /**
     * Возвращает значение хэш-кода для автомобиля
     *
     * @return целое число, представляющее хэш-код экземпляра
     */
    @Override
    public int hashCode() {
        int result = (model != null ? model.toLowerCase().hashCode() : 0);
        result = 31 * result + power;
        result = 31 * result + productionYear;
        return result;
    }

    /** Сравниваем экземпляры класса через компаратор
     * 
     * @return возвращаем результат сравнения
     */
    @Override
    public int compareTo(Car otherCar) {
        if (otherCar == null) {
            throw new NullPointerException("Сравниваемый объект не может быть null");
        }

        return CAR_COMPARATOR.compare(this, otherCar);
    }
}

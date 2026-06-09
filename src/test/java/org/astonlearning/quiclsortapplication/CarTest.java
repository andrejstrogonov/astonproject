package org.astonlearning.quiclsortapplication;

public class CarTest {
    public static void main(String[] args) {
        testBuilder();
        testToString();
        testHashCode();
        testEquals();
        testCompareTo();
    }

    private static boolean testBuilder() {
        Car car = new Car.Builder()
                .setPower(350)
                .setModel("BMW")
                .setProductionYear(2009)
                .build();

        String expectedModel = "BMW";
        int expectedPower = 350;
        int expectedProductionYear = 2009;

        if (car.getModel().equals(expectedModel) && car.getPower() == expectedPower
                && car.getProductionYear() == expectedProductionYear) {
            System.out.println("PASS: The class instance is created sucsessfully.");
            return true;
        } else {
            System.out.println(String.format("ERROR: expected 'model = %s, power = %d, productionYear = %d",
                    expectedModel, expectedPower, expectedProductionYear));
            System.out.println(String.format("received 'model = %s, power = %d, productionYear = %d", car.getModel(),
                    car.getPower(), car.getProductionYear()));
            return false;
        }
    }

    private static boolean testToString() {
        Car car = new Car.Builder()
                .setPower(250)
                .setModel("Audi")
                .setProductionYear(2010)
                .build();

        String expected = "Car{model='Audi', power=250 л.с., year=2010}";

        if (car.toString().equals(expected)) {
            System.out.println("PASS: toString() formed correct.");
            return true;
        } else {
            System.out.println(String.format("ERROR: expect '%s', received '%s'", expected, car.toString()));
            return false;
        }
    }

    private static boolean testHashCode() {
        Car car = new Car.Builder()
                .setPower(250)
                .setModel("Audi")
                .setProductionYear(2010)
                .build();

        Car sameCar = new Car.Builder()
                .setPower(250)
                .setModel("Audi")
                .setProductionYear(2010)
                .build();

        Car otherCar = new Car.Builder()
                .setPower(350)
                .setModel("BMW")
                .setProductionYear(2009)
                .build();

        Car lowerCaseOtherCar = new Car.Builder()
                .setPower(350)
                .setModel("bmw")
                .setProductionYear(2009)
                .build();

        /** Повторный вызов возвращает тот же хэш */
        if (car.hashCode() == car.hashCode()) {
            System.out.println("PASS: hashCode() is same across repeated calls.");
        } else {
            System.out.println("ERROR: Repeated calls to hashCode() returned different values.");
            return false;
        }

        /** У равных объектов хэш-коды должны совпадать */
        if (car.hashCode() == sameCar.hashCode()) {
            System.out.println("PASS: Hash codes of identical objects equal.");
        } else {
            System.out.println("ERROR: Identical objects have different hash codes.");
            return false;
        }

        /** Различность хэш-кодов для разных объектов */
        if (car.hashCode() != otherCar.hashCode()) {
            System.out.println("PASS: Different objects have different hash codes.");
        } else {
            System.out.println("WARNING: Hash code collision detected across different machines.");
        }

        /** Соответствие хэшей при разном регистре букв */
        if (otherCar.hashCode() == lowerCaseOtherCar.hashCode()) {
            System.out.println("PASS: Hash codes of objects with different cases match.");
        } else {
            System.out.println(
                    "ERROR: Contract broken! equals() will considers 'Audi' and 'audi' as equal, but they have different hashes.");
            return false;
        }
        return true;
    }

    private static boolean testEquals() {
        Car car = new Car.Builder()
                .setPower(250)
                .setModel("Audi")
                .setProductionYear(2010)
                .build();

        Car sameCar = new Car.Builder()
                .setPower(250)
                .setModel("Audi")
                .setProductionYear(2010)
                .build();

        Car otherCar = new Car.Builder()
                .setPower(350)
                .setModel("BMW")
                .setProductionYear(2009)
                .build();

        Car lowerCaseOtherCar = new Car.Builder()
                .setPower(350)
                .setModel("bmw")
                .setProductionYear(2009)
                .build();

        /** Рефлексивность. A == A */
        if (car.equals(car)) {
            System.out.println("PASS: A == A");
        } else {
            System.out.println("ERROR: Object is not equal to itself.");
            return false;
        }

        /** Симметричность. A == B and B == A */
        if (car.equals(sameCar) && sameCar.equals(car)) {
            System.out.println("PASS: Identical objects are equal.");
        } else {
            System.out.println("ERROR: Identical objects are not equal.");
            return false;
        }

        /** Неравенство при разных данных A != B */
        if (!car.equals(otherCar)) {
            System.out.println("PASS: Objects with different models are not equal.");
        } else {
            System.out.println("ERROR: Different cars recognized as equal.");
            return false;
        }

        /** Проверка регистра. A == a */
        if (otherCar.equals(lowerCaseOtherCar)) {
            System.out.println("PASS: The method ignores the case of characters in the model ('Audi' == 'audi').");
        } else {
            System.out.println("ERROR: Different letter case broke object equality.");
            return false;
        }

        /** Устойчивость к null A != null */
        if (!car.equals(null)) {
            System.out.println("PASS: equals() correctly handles null.");
        } else {
            System.out.println("ERROR: Failure comparing with null.");
            return false;
        }

        /** Сравнение с другим типом данных Car != String */
        if (!car.equals("String")) {
            System.out.println("PASS: equals() correctly handles other class.");
        } else {
            System.out.println("ERROR: Failure comparing with other class.");
            return false;
        }

        return true;
    }

    private static boolean testCompareTo() {
        Car bmwCar = new Car.Builder()
                .setModel("BMW")
                .setPower(350)
                .setProductionYear(2009)
                .build();

        Car lowerCaseBmwCar = new Car.Builder()
                .setModel("bmw")
                .setPower(350)
                .setProductionYear(2009)
                .build();

        /** Проверка регистру моделей */
        if (bmwCar.compareTo(lowerCaseBmwCar) == 0) {
            System.out.println("PASS: compareTo ignores the case of characters in the model name.");
        } else {
            System.out.println("ERROR: compareTo considered 'BMW' and 'bmw' to be different models.");
            return false;
        }

        /** Проверка по алфавиту моделей */
        Car audiCar = new Car.Builder()
                .setModel("Audi")
                .setPower(250)
                .setProductionYear(2010)
                .build();

        if (bmwCar.compareTo(audiCar) > 0) {
            System.out.println("PASS: Alphabetical sorting of models works (BMW > Audi).");
        } else {
            System.out.println("ERROR: Failed to sort models alphabetically.");
            return false;
        }

        /** Проверка по мощности) */
        Car lowPowerBmw = new Car.Builder()
                .setModel("BMW")
                .setPower(150)
                .setProductionYear(2011)
                .build();

        if (bmwCar.compareTo(lowPowerBmw) > 0) {
            System.out.println("PASS: Sorting by power works.");
        } else {
            System.out.println("ERROR: Failed to sort by power.");
            return false;
        }

        /** Проверка по году выпуска */
        Car olderBmw = new Car.Builder()
                .setModel("BMW")
                .setPower(350)
                .setProductionYear(2000)
                .build();

        if (bmwCar.compareTo(olderBmw) > 0) {
            System.out.println("PASS: Sorting by year of release works.");
        } else {
            System.out.println("ERROR: Сбой сортировки по году выпуска.");
            return false;
        }

        /** Проверка на NullPointerException */
        boolean nullPionterExceptionTest = true;
        try {
            bmwCar.compareTo(null);
            System.out.println("ERROR: The method did not throw a NullPointerException when passed null.");
            nullPionterExceptionTest = false;
        } catch (NullPointerException e) {
            System.out.println("PASS: Catch NullPointerException when comparing with null.");
        }

        if (!nullPionterExceptionTest)
            return false;
        else
            return true;
    }
}

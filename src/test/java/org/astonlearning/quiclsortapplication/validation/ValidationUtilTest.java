package org.astonlearning.quiclsortapplication.validation;

import org.astonlearning.quiclsortapplication.Car;

public class ValidationUtilTest {
    public static void main(String[] args) {
        Car car1 = null;
        System.out.println(
            "Test null car: " + 
            (ValidationUtil.isValid(car1) == false ? "PASS" : "FAIL")
        );
        
        Car car2 = new Car(100, null, 2010);
        System.out.println(
            "Test null model: " +
            (ValidationUtil.isValid(car2) == false ? "PASS" : "FAIL")
        );

        Car car3 = new Car(100, "   ", 2010);
        System.out.println(
            "Test empty model: " + 
            (ValidationUtil.isValid(car3) == false ? "PASS" : "FAIL")
        );

        Car car4 = new Car(-10, "BMW", 2010);
        System.out.println(
            "Test negative power: " + 
            (ValidationUtil.isValid(car4) == false ? "PASS" : "FAIL")
        );

        Car car5 = new Car(100, "BMW", 1800);
        System.out.println(
            "Test year too small: " + 
            (ValidationUtil.isValid(car5) == false ? "PASS" : "FAIL")
        );

        Car car6 = new Car(100, "BMW", 3000);
        System.out.println(
            "Test year too big: " + 
            (ValidationUtil.isValid(car6) == false ? "PASS" : "FAIL")
        );

        Car car7 = new Car(150, "Audi", 2015);
        System.out.println(
            "Test valid car: " + 
            (ValidationUtil.isValid(car7) == true ? "PASS" : "FAIL")
        );
    }
}

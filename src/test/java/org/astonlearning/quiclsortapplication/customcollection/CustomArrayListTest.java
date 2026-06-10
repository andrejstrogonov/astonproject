package org.astonlearning.quiclsortapplication.customcollection;

public class CustomArrayListTest {
    public static boolean emptyListTest(){
        CustomArrayList<String> list = new CustomArrayList<>();

        if (list.size() == 0) {
            System.out.println("PASS: list is empty.");
            return true;
        } else {
            System.err.println("ERROR: list not empty, size = " + list.size());
            return false;
        }
    }

    public static boolean addElementTest(){
        CustomArrayList<String> list = new CustomArrayList<>();
        boolean el1 = list.add("First");
        boolean el2 = list.add("Second");

        if (el1 && el2 && list.size() == 2 && "First".equals(list.get(0)) && "Second".equals(list2.get(1))) {
            System.out.println("PASS: elements added correctly");
            return true;
        } else {
            System.err.println("ERROR: fail to add elements");
            return false;
        }
    }

    public static boolean autoExpanceTest(){
        CustomArrayList<String> list = new CustomArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("El " + i);
        }
        
        try {
            list.add("10"); // 11-й элемент провоцирует расширение
            if (list.size() == 11 && "10".equals(list.get(10))) {
                System.out.println("PASS: list sucsessfuly expand");
                return true;
            } else {
                System.err.println("ERROR: wrong size or element after expand");
                return false;
            }
        } catch (Exception e) {
            System.err.println("ERROR: exception: " + e.getMessage());
            return false;
        }
    }

    public static boolean indexGetOutOfBoundExceptionTest(){
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Java");
        boolean hasExceptionGetMinus = false;
        boolean hasExceptionGetOut = false;

        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            hasExceptionGetMinus = true;
        }

        try {
            list.get(1); // При размере 1 индекс 1 недоступен
        } catch (IndexOutOfBoundsException e) {
            hasExceptionGetOut = true;
        }

        if (hasExceptionGetMinus && hasExceptionGetOut) {
            System.out.println("PASS: get cirrectly throw IndexOutOfBoundsException");
            return true;
        } else {
            System.err.println("ERROR: get not throw exception");
            return false;
        }
    }

    public static boolean setTest(){
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("B");
        String oldVal = list.set(1, "C");

        if ("Banana".equals(oldVal) && "C".equals(list.get(1)) && list.size() == 2) {
            System.out.println("PASS: set correctly exchange element");
            return true;
        } else {
            System.err.println("[ERROR: set working incorrect");
            return false;
        }
    }

    public static boolean indexSetOutOfBoundExceptionTest(){
        CustomArrayList<String> list = new CustomArrayList<>();
        boolean hasExceptionSet = false;
        try {
            list.set(0, "Error");
        } catch (IndexOutOfBoundsException e) {
            hasExceptionSet = true;
        }

        if (hasExceptionSet) {
            System.out.println("PASS: set correctly throw IndexOutOfBoundsException");
            return true;
        } else {
            System.err.println("ERROR: set not throw exception");
            return false;
        }
    }

    public static boolean removeTest(){
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String removedMiddle = list.remove(1); // Удаляем "B"

        if ("B".equals(removedMiddle) && list.size() == 2 && "A".equals(list.get(0)) && "C".equals(list.get(1))) {
            System.out.println("PASS: remove work correct");
            return true;
        } else {
            System.err.println("ERROR: remove work incorrect");
            return false;
        }
    }

    public static boolean indexRemoveOutOfBoundExceptionTest(){
        CustomArrayList<String> list = new CustomArrayList<>();
        boolean hasExceptionRemove = false;
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            hasExceptionRemove = true;
        }

        if (hasExceptionRemove) {
            System.out.println("PASS: remove correctly throw IndexOutOfBoundsException");
            return true;
        } else {
            System.err.println("ERROR: remove not throw exception");
            return false;
        }
    }
}

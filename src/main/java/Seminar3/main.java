package Seminar3;

import static Seminar3.CompareArrays.compareArrays;

public class main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        Calculate calculate = new Calculate();
        System.out.println("Сложение " + calculate.sum(20.4, 4));
        try {
            System.out.println("Деление " + calculate.divide(20.4, 4));
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        System.out.println("Умножение " + calculate.multiply(20.4, 4));
        System.out.println("Вычитание " + calculate.subtract(20.4, 4));

        System.out.println("_______________________________");
        System.out.println("Задача 2");
        Integer[] arr1 = {3, 2, 5};
        Float[] arr2 = {1.0f, 3f, 5f};
        Integer[] arr3 = {3, 1, 5};
        Integer[] arr4 = {4, 2, 5};
        System.out.println("Сравнение int и float "+compareArrays(arr1, arr2));
        System.out.println("Сравнение двух int массивов " + compareArrays(arr3, arr4));

        System.out.println("_______________________________");
        System.out.println("Задача 3");
        Pair pair = new Pair<>("String", 25);
        System.out.println(pair);

    }
}

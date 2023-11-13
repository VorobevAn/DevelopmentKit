package Seminar3;
//Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
// если они одинаковые, и false в противном случае.
// Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.


public class CompareArrays  {
    public static <T> boolean compareArrays(T[] list1, T[] list2) {
        return list1.length == list2.length & list1[0].getClass() == list2[0].getClass();
    }

}

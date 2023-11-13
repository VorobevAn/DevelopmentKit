package Seminar3;
//Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
// Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
// а также переопределение метода toString(), возвращающее строковое представление пары.
public class Pair<T,S> {
    private T element1;
    private S element2;

    public Pair(T element1, S element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public T getFirst(){
return element1;
    }
    public S getSecond(){
        return element2;
    }



        @Override
    public String toString() {
        return "Pair{" + element1 +" "+ element2 +'}';
    }
}

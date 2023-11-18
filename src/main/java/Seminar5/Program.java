package Seminar5;

public class Program {
    private static final int PHILOSOPHER = 5;
    private static final int NUMBEROFMEALS = 3;
    private final Philosopher[] philosophers = new Philosopher[PHILOSOPHER];
    private final Fork[] forks = new Fork[PHILOSOPHER];


    /**
     * Заполнение списков философов и вилок
     */
    public void start() throws InterruptedException {
        for (int i = 0; i < forks.length; i++) {
            if (i % 2 == 0) {
                forks[i] = new Fork(true);
            } else {
                forks[i] = new Fork(false);
            }
        }
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[endOfArray(i)], NUMBEROFMEALS);
            new Thread(philosophers[i]).start();
            Thread.sleep(200);
        }

    }

    /**
     * Проверка на конец списка, если философ последний
     * ему в качестве правой вилки, присваивается левая вилка первого философа
     * @param index проверяемый индекс
     * @return возвращает нужный индекс
     */
    public int endOfArray(int index) {
        if (index == PHILOSOPHER) {
            return 0;
        }
        return index;
    }

}

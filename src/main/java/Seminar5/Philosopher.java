package Seminar5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
    private final int id;
    private final Fork forkLeft;
    private final Fork forkRight;
    private final int numberOfMeals;
    private int count = 1;
    private final Lock lock = new ReentrantLock();

    public Philosopher(int id, Fork forkLeft, Fork forkRight, int numberOfMeals) {
        this.id = id;
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
        this.numberOfMeals = numberOfMeals;
    }

    @Override
    public void run() {

        while (count <= numberOfMeals) {
            try {
                Thread.sleep(1000);
                isStatus();
                forkLeft.revers();
                // forkRight.revers();  Долго искал решение пока случайно не закомментировал.


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * Вывод статуса философа
     */
    public void isStatus() {
        if (forkLeft.isLies() & forkRight.isLies()) {
            System.out.println(id + 1 + " философ ест " + count + "раз");
            count++;
        } else {
            System.out.println(id + 1 + " философ размышляет");
        }
    }
}

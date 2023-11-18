package Seminar5;

import java.util.concurrent.Semaphore;

public class Fork {
   // Semaphore fork = new Semaphore(1);
   private boolean lies;

    public Fork(boolean lies) {
        this.lies = lies;
    }

    public boolean isLies() {
        return lies;
    }

    public void setLies(boolean lies) {
        this.lies = lies;
    }

    public void revers(){
        lies =!lies;
    }


    public void up() {
//        try {
//            fork.acquire();
            lies = true;
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

    }
    public void down(){
//        fork.release();
        lies = false;
    }
}

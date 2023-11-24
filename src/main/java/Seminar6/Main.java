package Seminar6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    static int NUMBERGAMES = 1000;
    static Random random = new Random();
    static String[] door;
    static Map<Integer, Boolean> result = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < NUMBERGAMES; i++) {
            result.put(i, start());
        }
        int victory = 0;
        for (Map.Entry<Integer, Boolean> entry : result.entrySet()) {
            if (entry.getValue()) {
                victory++;
            }
        }
        System.out.println("Количество побед из " + NUMBERGAMES + " = " + victory);
    }

    public static boolean start() {
        door = new String[]{"goat", "goat", "goat"};
        int auto = random.nextInt(0, 3);
        door[auto] = "auto";

        int selectedDoor = random.nextInt(0, 3);
        boolean q = true;
        while (q) {
            int index = random.nextInt(0, 3);
            if (!door[index].equals("auto") || index != selectedDoor) {
                door[index] = null;
                q = false;
            }
        }

        // смена выбранной двери

        for (int i = 0; i <door.length ; i++) {
            if (i != selectedDoor || door[i] != null){
                selectedDoor = i;
            }
        }

        if (selectedDoor == auto) {
            return true;
        }
        return false;

    }


}

package com.example.call_center;

import java.util.Random;

public class Operators {
    private final Ats ats;
    Random random = new Random();
    int startingPointTime = 3500;
    int initialTime = 3000;
    int endingTime = 4500;

    public void takeCalls() {
        try {
            Thread.sleep(startingPointTime);
            while (!ats.customers.isEmpty()) {
                if (ats.getQueue().element() != null) {
                    String currentName = ats.getQueue().poll();
                    System.out.printf("принят вызов от клиента %s оператором %s ." +
                            " вызов обрабатывается ..... \n", currentName, Thread.currentThread().getName());
                    Thread.sleep(random.nextInt(initialTime, endingTime));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Operators(Ats ats) {
        this.ats = ats;
    }
}

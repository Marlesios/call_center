package com.example.call_center;

import java.util.Random;

public class Operators {
    private final Ats ats;
    Random random = new Random();
    int startingPointTime = 3000;
    int waitingTime = 2000;

    public void takeCalls() {
        try {
            Thread.sleep(startingPointTime);
            while (!ats.customers.isEmpty()) {
                if (!ats.getQueue().element().equals("null")) {
                    Thread.sleep(waitingTime);
                    String currentName = ats.getQueue().poll();
                    System.out.printf("принят вызов от клиента %s оператором %s .", currentName, Thread.currentThread().getName());
                    System.out.println("вызов обрабатывается  ..........");
                    Thread.sleep(random.nextInt(500, 1500));
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

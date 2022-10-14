package com.example.call_center;

public class Operators {
    private final Ats ats;
    public void takeCalls(){
        try {
            Thread.sleep(3000);
            System.out.printf("принят вызов от клиента %s", ats.getQueue().poll());
            System.out.println("вызов обрабатывается");

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public Operators(Ats ats ){this.ats = ats;}
}

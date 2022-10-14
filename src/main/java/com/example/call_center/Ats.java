package com.example.call_center;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Ats {
    Operators operator = new Operators(this);
    Random random = new Random();
    private int callingTimeGap = 1000;
    ConcurrentLinkedQueue<String> customers = new ConcurrentLinkedQueue<>();
    String[] names ={"max","sergey","Shera","Aidar","Jessica","Steve","Adora","Queeny","Deepa","Joy","Kuba"};
    public void addCustomers() {
        for(int i = 0; i < 200;i++ ) {
            try {
                Thread.sleep(callingTimeGap);
                String temporaryCustomer = names[random.nextInt(names.length)];
                customers.add(temporaryCustomer);
                System.out.println(customers.poll());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public ConcurrentLinkedQueue<String> getQueue(){
        return customers;
    }
}

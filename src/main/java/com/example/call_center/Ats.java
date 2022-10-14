package com.example.call_center;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Ats {
    Operators operator = new Operators(this);
    Random random = new Random();
    private int callingTimeGap = 1000;
    ConcurrentLinkedQueue<String> customers = new ConcurrentLinkedQueue<>();
    //ConcurrentLinkedQueue я использовал потому она работает в принципе быстро и без блокировок
    // да и тут нет слишком больших количеств звонков для того чтоб загрузить коллекцию
    String[] names ={"max","sergey","Shera","Aidar","Jessica","Steve","Adora","Queeny","Deepa","Joy","Kuba"};
    public void addCustomers() {
        for(int i = 0; i < 20;i++ ) {
            try {
                Thread.sleep(callingTimeGap);
                String temporaryCustomer = names[random.nextInt(names.length)] + i;
                customers.add(temporaryCustomer);
                System.out.println("поступает звонок от клиента : " + temporaryCustomer);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public ConcurrentLinkedQueue<String> getQueue(){
        return customers;
    }
}

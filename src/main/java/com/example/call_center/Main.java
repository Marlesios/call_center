package com.example.call_center;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        Ats ats = new Ats();
        Operators operator1 = new Operators(ats);

        Thread thread1 = new Thread(null,ats::addCustomers,"operator 1");
        new Thread(null,operator1::takeCalls,"sasha").start();
        thread1.start();



    }
}

package com.example.call_center;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        Ats ats = new Ats();
        Operators operator = new Operators(ats);

        new Thread(null,ats::addCustomers,"operator 1").start();
        new Thread(null,operator::takeCalls,"Sasha").start();
        new Thread(null,operator::takeCalls,"Gosha").start();
        new Thread(null,operator::takeCalls,"Egor").start();



    }
}

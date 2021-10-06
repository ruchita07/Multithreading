package com.ruchita;

import java.util.Arrays;

class Counter {
    int count;
    //synchronized method - only one thread can work on this method other thread has to wait
    public synchronized void increment() {
        count++;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void  run() {
                for(int i = 0; i < 1000; i++) c.increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);

    }
}

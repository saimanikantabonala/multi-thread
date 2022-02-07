package com.example;

public class ThreadExample {
    static int value = 0;

    public static void main(String[] args) throws InterruptedException {
        Workers workers = new Workers();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    workers.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    workers.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
    }
}

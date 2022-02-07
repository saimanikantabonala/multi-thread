package com.example;

public class Workers {
    public void producer() throws InterruptedException {
        synchronized (this) {
            while (ThreadExample.value < 5) {
                notify();
                ThreadExample.value++;
                System.out.println("Producer produced-" + ThreadExample.value);
                wait();
            }

        }
    }

    public void consumer() throws InterruptedException {
        synchronized (this) {
            while (ThreadExample.value < 5) {
                wait();
                System.out.println("Consumer consumed-" + ThreadExample.value);
                notify();
            }
        }
    }
}

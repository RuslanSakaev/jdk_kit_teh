package org.example.hw.hw5;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Fork[] forks = new Fork[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) { // Создаем философов и вилки
            forks[i] = new Fork();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]);
            Thread t = new Thread(philosophers[i]); // Создаем потоки для каждого философа и запускаем их
            t.start();
        }
    }
}

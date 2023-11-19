package org.example.hw.hw5;


public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            think();
            if (pickUpForks()) {
                eat();
                putDownForks();
            }
        }
    }

    private void think() {
        System.out.println("Философ " + id + " думает");
    }

    private boolean pickUpForks() {
        if (leftFork.pickUp()) {
            System.out.println("Философ " + id + " взял левую вилку");
            if (rightFork.pickUp()) {
                System.out.println("Философ " + id + " взял правую вилку");
                return true;
            } else {
                leftFork.putDown();
                System.out.println("Философ " + id + " положил левую вилку");
                return false;
            }
        }
        return false;
    }

    private void eat() {
        System.out.println("Философ " + id + " ест");
    }

    private void putDownForks() {
        leftFork.putDown();
        System.out.println("Философ " + id + " положил левую вилку");
        rightFork.putDown();
        System.out.println("Философ " + id + " положил правую вилку");
    }
}

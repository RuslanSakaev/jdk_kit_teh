package org.example.hw.hw5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {
    private final Lock lock;

    public Fork() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        return lock.tryLock(); // Попытаться заблокировать вилку и вернуть true, если успешно
    }

    public void putDown() {
        lock.unlock(); // Разблокировать вилку
    }
}

package org.example.hw.hw5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final Lock lock;
    private boolean isTaken;

    public Fork() {
        lock = new ReentrantLock();
        isTaken = false;
    }

    public boolean pickUp() {
        if (!isTaken && lock.tryLock()) {
            isTaken = true;
            return true;
        }
        return false;
    }

    public void putDown() {
        if (isTaken) {
            lock.unlock();
            isTaken = false;
        }
    }
}

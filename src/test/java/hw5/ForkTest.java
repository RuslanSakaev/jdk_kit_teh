//package hw5;
//
//import org.example.hw.hw5.Fork;
//import org.example.hw.hw5.Philosopher;
//import org.junit.Test;
//
//import java.util.concurrent.CountDownLatch;
//
//public class DiningPhilosophersConcurrentTest {
//    @Test
//    public void testConcurrentDiningPhilosophers() throws InterruptedException {
//        int numPhilosophers = 5;
//        Philosopher[] philosophers = new Philosopher[numPhilosophers];
//        Fork[] forks = new Fork[numPhilosophers];
//        CountDownLatch startLatch = new CountDownLatch(1);
//
//        for (int i = 0; i < numPhilosophers; i++) {
//            forks[i] = new Fork();
//        }
//
//        for (int i = 0; i < numPhilosophers; i++) {
//            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]);
//            Thread t = new Thread(philosophers[i]);
//            t.start();
//        }
//
//        // Ожидаем, пока все философы успешно захватят вилки
//        startLatch.countDown();
//        Thread.sleep(5000); // Подождем несколько секунд
//
//        for (Philosopher philosopher : philosophers) {
//            // Проверяем, что философ взял обе вилки
//            assertPhilosopherHasBothForks(philosopher);
//        }
//    }
//
//    private void assertPhilosopherHasBothForks(Philosopher philosopher) {
//        // Проверка, что у философа взяты обе вилки
//        boolean hasLeftFork = philosopher.getLeftFork().isTaken();
//        boolean hasRightFork = philosopher.getRightFork().isTaken();
//        assert hasLeftFork && hasRightFork;
//    }
//}

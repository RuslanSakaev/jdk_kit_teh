package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {

    public static void main(String[] args) {
        int totalGames = 1000;
        Map<Integer, Boolean> resultsWithSwitch = new HashMap<>();
        Map<Integer, Boolean> resultsWithoutSwitch = new HashMap<>();

        // Играем в парадокс Монте Холла заданное количество раз
        for (int i = 1; i <= totalGames; i++) {
            boolean winWithSwitch = playMontyHall(true);
            resultsWithSwitch.put(i, winWithSwitch);

            boolean winWithoutSwitch = playMontyHall(false);
            resultsWithoutSwitch.put(i, winWithoutSwitch);
        }

        // Выводим статистику по результатам игр
        displayResults("При смене выбора", resultsWithSwitch);
        displayResults("Без смены выбора", resultsWithoutSwitch);
    }

    // Метод, реализующий одну игру в парадокс Монте Холла
    private static boolean playMontyHall(boolean switchDoor) {
        Random random = new Random();
        int prizeDoor = random.nextInt(3) + 1; // Выбор двери, за которой приз
        int chosenDoor = random.nextInt(3) + 1; // Игрок выбирает дверь

        int hostOpens = getHostOpenedDoor(prizeDoor, chosenDoor); // Хост открывает дверь

        // Игрок решает менять выбор двери или оставить текущий
        if (switchDoor) {
            chosenDoor = switchDoor(chosenDoor, hostOpens);
        }

        return chosenDoor == prizeDoor; // Возвращаем результат игры (победа или поражение)
    }

    // Метод, определяющий, какую дверь открывает хост
    private static int getHostOpenedDoor(int prizeDoor, int chosenDoor) {
        Random random = new Random();
        int hostOpens;
        do {
            hostOpens = random.nextInt(3) + 1;
        } while (hostOpens == prizeDoor || hostOpens == chosenDoor);
        return hostOpens;
    }

    // Метод, реализующий изменение выбора двери игроком
    private static int switchDoor(int chosenDoor, int hostOpenedDoor) {
        for (int i = 1; true; i++) {
            if (i != chosenDoor && i != hostOpenedDoor) {
                return i;
            }
        }
    }

    // Метод, выводящий на экран статистику по результатам игр
    private static void displayResults(String message, Map<Integer, Boolean> results) {
        int wins = 0;
        int losses = 0;

        // Подсчитываем количество побед и поражений
        for (boolean result : results.values()) {
            if (result) {
                wins++;
            } else {
                losses++;
            }
        }

        // Выводим статистику
        System.out.println("Результаты " + message + ":");
        System.out.println("Всего игр: " + results.size());
        System.out.println("Побед: " + wins);
        System.out.println("Поражений: " + losses);
        System.out.println();
    }
}
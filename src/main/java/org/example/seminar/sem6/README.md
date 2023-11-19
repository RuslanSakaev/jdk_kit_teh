Пример решения для создания файла вне структуры папки с помощи __getClassLoader()__:
```
void test() {
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("test.txt")) {
            if (resourceAsStream != null) {
                System.out.println(new String(resourceAsStream.readAllBytes()));
            } else {
                System.out.println("Ресурс не найден");
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
```
1. В рамках выполнения задачи необходимо:
   Создать свой Java Maven проект;
   Добавьте зависимость commons-math3 (предназначена для решения математических задач) и изучить интерфейс библиотеки.
   Воспользоваться пакетом org.apache.commons.math3.stat и классом DescriptiveStatistics.
   Создать коллекцию из числовых элементов.
   С помощью объекта DescriptiveStatistics вычислить минимальное и максимальное значение, сумму и среднее арифметическое.
   Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса ArithmeticUtils найти:
   факториал числа N.
   Наименьшее общее частное двух чисел
   Наибольший общий делитель двух чисел
   Проверить, что число N это степень двойки
2. В рамках выполнения задачи необходимо:
   Создать свой Java Gradle проект;
   Добавить зависимость Guava (популярная библиотека от Google, содержащая набор утилитарных механизмов).
   Воспользоваться утилитарным классом Lists:
   Развернуть список элементов;
   Получить лист Character из строки;
   Разделить лист на группы по 2 элемента;
   Воспользоваться утилитарным классом Sets;
   Получить итоговый Set из двух коллекций;
   Получить итоговый Set из общих элементов двух коллекций;
   Получить итоговый Set из непересекающихся элементов двух коллекций.
3. ДЗ: В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла 
   (Парадокс Монти Холла — Википедия) и наглядно убедиться в верности парадокса 
   (запустить игру в цикле на 1000 и вывести итоговый счет).
   Необходимо:
   Создать свой Java Maven или Gradle проект;
   Самостоятельно реализовать прикладную задачу;
   Сохранить результат в HashMap<шаг теста, результат>;
   Вывести на экран статистику по победам и поражениям

# Java Development Kit (семинары)
## Урок 6. Управление проектом: сборщики проектов
#### В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
~~~
https://ru.wikipedia.org/wiki/%D0%9F%D0%B0%D1%80%D0%B0%D0%B4%D0%BE%D0%BA%D1%81_%D0%9C%D0%BE%D0%BD%D1%82%D0%B8_%D0%A5%D0%BE%D0%BB%D0%BB%D0%B0
~~~
##### Необходимо:
- Создать свой Java Maven или Gradle проект;
- Самостоятельно реализовать прикладную задачу;
- Сохранить результат в HashMap<шаг теста, результат>
- Вывести на экран статистику по победам и поражениям

Пример решения:
```
package jdk.seminars.hw;
import java.util.*;
/*
* проверка парадокса Монти-Холла на примере трех шкатулок в одной из которыйх миллион
*
* 1й вариант: игрок случайно выбирает одну из шкатулок и не меняет свое решение,
* и всегда остается при своём первом выборе
*
* 2й вариант: игрок случайно выбирает одну из дверей, далее ведущий убирает одну пустую из оставшихся
* и перелагает сменить шкатулку на что пользователь соглашается
*
* в каждом случае подсчитаем число выигрышей во множестве итераций и переведем в процентное отношение
* 
* */
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Map<Integer, Boolean> result = new HashMap<>(); //мапа с результами каждой итерации (непонятно зачем)))
        int maxSteps = 1000; // число итераций


        // реализация первого варианта
        double counterWin = 0;
        for (int i = 0; i < maxSteps; i++) {
            boolean[] boxes = getBoxes(); //перемешиваем шкатулки
            int selectedBox = rnd.nextInt(3); // игрок выбирает одну из шкатулок
            if (boxes[selectedBox]) counterWin++; //проверяем выиграл ли он и сохраняем результат
            result.put(i, boxes[selectedBox]);
        }
        System.out.printf("Результат по первому варианту при %d итераций: %.3f%%\n",maxSteps, (counterWin / maxSteps * 100));

        // реализация второго врианта
        counterWin = 0;
        for (int i = 0; i < maxSteps; i++) {
            boolean[] boxes = getBoxes();// перемешиваем шкатулки
            int selectedBox = rnd.nextInt(3);//игрок выбирает одну из шкатулок
            selectedBox = getSecondBox(selectedBox, boxes); //игрок меняет выбранную шкатулку на ту, что предложит ведущий
            if (boxes[selectedBox]) counterWin++;
            result.put(i+maxSteps, boxes[selectedBox]);//проверяем выиграл ли он и сохраняем результат
        }
        System.out.printf("Результат по второму варианту при %d итераций: %.3f%%\n",maxSteps, (counterWin / maxSteps * 100));
    }

    /**
     * Возвращает индекс шкатулки, которую предлагает открыть ведущий
     * @param userSelectedBox
     * @param boxes
     * @return
     */
    private static int getSecondBox(int userSelectedBox, boolean[] boxes) {
        Random rnd = new Random();
        int selectSecondBox;
        if (boxes[userSelectedBox]){
         // начальный выбор игрока был правильный
         while (true){
             //предлагаем любую из оставшихся шкатулок
             selectSecondBox = rnd.nextInt(3);
             if(selectSecondBox!=userSelectedBox) return selectSecondBox;
         }
        }else{
            //если начальный выбор был проигрышный,
            // то предлагаем шкатулку с призом
            while (true){
                for (int i = 0; i < 3; i++) {
                    if(boxes[i]) return i;
                }
            }
        }
    }

    /**
     * Возвращает массив шкатулок, в одной из которого приз
     * @return
     */
    private static boolean[] getBoxes() {

        Random rnd = new Random();
        boolean[] boxes = new boolean[]{false, false, false};
        boxes[rnd.nextInt(3)] = true;
        return boxes;
    }
}

```
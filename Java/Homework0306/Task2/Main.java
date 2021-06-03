package Homework0306.Task2;

import java.security.InvalidParameterException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = {"abcdefghijklmnopqrstuvwxyz", "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"};
        var executor = Executors.newScheduledThreadPool(4);

        int value = sc.nextInt();
        if (value < 0) throw new InvalidParameterException("Вы ввели отрицательное число!");

        for (int i = 0; i < value; i++) {
            executor.schedule(() -> {
                int num = rand.nextInt(5) + 1;
                int lang = rand.nextInt(2);
                for (int j = 0; j < num; j++) {
                    char ch = arr[lang].charAt(rand.nextInt(arr[lang].length()));
                    stringBuilder.append(ch);
                }
                System.out.println(Thread.currentThread().getName() + " added new chars\n" + stringBuilder);
            }, 3000, TimeUnit.MILLISECONDS);
        }
        executor.shutdown();
        if (executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            executor.shutdownNow();
        }
        System.out.println("Result is " + stringBuilder);
    }
}

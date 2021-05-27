package Homework2705;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static volatile long fact = 1;

    public static void main(String[] args) throws Exception {
        System.out.println("---First task---");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = in.nextInt();
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is working... \n" +
                    Thread.currentThread().getName() + " result is: " + fact(n, 1));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is working... \n" +
                    Thread.currentThread().getName() + " result is: " + fact(n, 2));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is working... \n" +
                    Thread.currentThread().getName() + " result is: " + fact(n, 3));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is working... \n" +
                    Thread.currentThread().getName() + " result is: " + fact(n, 4));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(n + "! = " + fact);

        System.out.println("\n---Second task---");
        ArrayList<String> evenWords = new ArrayList<>();
        ArrayList<String> oddWords = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Git/GizetdinovA_11005/Java/Homework2705/input.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] str = s.split(" ");
                for (String value : str) list.add(value.toLowerCase());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Thread threadEven = new Thread(() -> list.forEach((x) -> {
            long k = x.chars().asLongStream()
                    .distinct().count();
            if (k % 2 == 0) {
                evenWords.add(x);
                System.out.println(Thread.currentThread().getName() + " added " + x + "to Even words list;");
            }
        }));
        Thread threadOdd = new Thread(() -> list.forEach((x) -> {
            long k = x.chars().asLongStream()
                    .distinct().count();
            if (k % 2 != 0) {
                oddWords.add(x);
                System.out.println(Thread.currentThread().getName() + " added " + x + " to Odd words list;");
            }
        }));

        threadEven.start();
        threadOdd.start();
        threadEven.join();
        threadOdd.join();

        System.out.println("-Result:\nEven words list:\n" + evenWords +
                "\nOdd words list:\n" + oddWords);
    }

    public static long fact(int n, int c) {
        if (c == 1) {
            for (int i = 1; i < n / 4 + 1; i++) {
                fact *= i;
            }
        }
        if (c == 2) {
            for (int i = n / 4 + 1; i < n / 2 + 1; i++) {
                fact *= i;
            }
        }
        if (c == 3) {
            for (int i = n / 2 + 1; i < 3 * n / 4 + 1; i++) {
                fact *= i;
            }
        }
        if (c == 4) {
            for (int i = 3 * n / 4 + 1; i < n + 1; i++) {
                fact *= i;
            }
        }
        return fact;
    }
}

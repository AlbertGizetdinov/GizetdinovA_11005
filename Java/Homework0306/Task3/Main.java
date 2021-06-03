package Homework0306.Task3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static int n;
    static String result = "";
    static AtomicInteger l = new AtomicInteger(0);
    static AtomicInteger r = new AtomicInteger(10);

    public static String primeNum(AtomicInteger start, AtomicInteger end) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int j = start.intValue(); j < end.intValue(); j++) {
            int i = j;
            boolean res = IntStream.rangeClosed(2, j / 2).anyMatch(x -> i % x == 0);
            if (!res) arr.add(j);
        }
        return arr.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        n = sc.nextInt();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        while (l.get() <= n) {
            executorService.submit(()-> {
                result = primeNum(l, r);
                l.set(r.get() + 1);
                r.set(r.get() + 10);
                System.out.println(Thread.currentThread().getName() + " is " + result);
                return result;
            });
            Thread.sleep(1500);
        }
        executorService.shutdown();
    }
}

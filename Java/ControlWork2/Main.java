package ControlWork2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Order {
    final String name;
    final String order;
    final Integer amount;

    public Order(String name, String order, Integer amount) {
        this.name = name;
        this.order = order;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return order;
    }
}

public class Main {
    public static void method1() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("task1.txt"));
        List<Order> orderList = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] splitLine = line.split("\\|");
            String name = splitLine[0];
            String order = splitLine[1];
            Integer amount = Integer.parseInt(splitLine[2]);
            orderList.add(new Order(name, order, amount));
        }

        bufferedReader.close();

        orderList.stream()
                .collect(Collectors.groupingBy(Order::getName))
                .forEach((key, value) -> System.out.println(key + " " + value.stream().max(Comparator.comparingInt(Order::getAmount)).get()));
    }

    public static void method2() throws Exception{
        FileReader fileReader = new FileReader("task2.txt");
        Scanner sc = new Scanner(fileReader);
        String[] s = new String[10000];
        int i = 0;

        while (sc.hasNextLine()) {
            s[i] = sc.nextLine();
            i++;
        }

        fileReader.close();

        Map<String, Integer> map = Arrays.stream(s).collect(Collectors.toMap(
                str1 -> str1.substring(0, str1.indexOf('|')),
                str1 -> Integer.parseInt(str1.substring(str1.indexOf('|') + 1)),
                (x, y) -> x = x + y));

        int S = 0;
        int k = map.size();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            S += entry.getValue();
        }
        S = S / k;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > S) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public static void method3() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("task1.txt"));
        List<Order> orderList = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] splitLine = line.split("\\|");
            String name = splitLine[0];
            String order = splitLine[1];
            Integer amount = Integer.parseInt(splitLine[2]);

            orderList.add(new Order(name, order, amount));
        }

        bufferedReader.close();

        orderList.stream()
                .collect(Collectors.groupingBy(Order::getOrder))
                .forEach((key, value) ->
                        System.out.println(key
                                + ", min: " + value.stream().min(Comparator.comparingInt(Order::getAmount)).get().getAmount()
                                + " , max: " + value.stream().max(Comparator.comparingInt(Order::getAmount)).get().getAmount()));
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        Thread thread1 = new Thread(() -> {
            try {
                method1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                method2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                method3();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        while (true) {
            int a = in.nextInt();

            if (a == 0) return;
            if (a == 1) { thread1.start(); thread1.join(); }
            if (a == 2) { thread2.start(); thread2.join(); }
            if (a == 3) { thread3.start(); thread3.join(); }
        }
    }
}

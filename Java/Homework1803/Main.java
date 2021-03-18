package Homework1803;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Задание 1: Частотный словарь слов
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        str = str + " ";
        String strFor = "";
        int j = str.length();
        int i = 0;
        while (j > 0) {
            if (str.charAt(i) != ' ') {
                strFor = strFor + str.charAt(i);
            } else {
                if (map.containsKey(strFor)) {
                    map.put(strFor, (map.get(strFor) + 1));
                } else {
                    map.put(strFor, 1);
                }
                strFor = "";
            }
            i++;
            j--;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //Задание 2: Информация о покупках
        HashMap<String, Map<String, Integer>> orders = new HashMap<>();
        int a = 5;
        String name;
        String product;
        int amount;
        while (a > 0) {
            System.out.println("Имя покупателя: ");
            name = sc.next();
            if (orders.containsKey(name)) {
                System.out.println("Что купил: ");
                product = sc.next();
                if (orders.get(name).containsKey(product)) {
                    System.out.println("В каком количестве: ");
                    amount = sc.nextInt();
                    orders.get(name).put(product, (orders.get(name).get(product) + amount));
                } else {
                    System.out.println("В каком количестве: ");
                    amount = sc.nextInt();
                    orders.get(name).put(product, amount);
                }
            } else {
                System.out.println("Что купил: ");
                product = sc.next();
                System.out.println("В каком количестве: ");
                amount = sc.nextInt();
                orders.put(name, new HashMap<>());
                orders.get(name).put(product, amount);
            }
            a--;
        }
        for (Map.Entry<String, Map<String, Integer>> entry : orders.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> value : entry.getValue().entrySet()) {
                System.out.println("\t" + value.getKey() + " - " + value.getValue());
            }
        }
    }
}
package Classwork;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        HashMap<String, HashMap<String, HashMap<String, Integer>>> buyers = new HashMap<>();
        File file = new File("C:/Git/GizetdinovA_11005/Java/Classwork/orders.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split("\\|");

            if (!buyers.containsKey(arr[0])) {
                HashMap<String, HashMap<String, Integer>> cities = new HashMap<>();
                HashMap<String, Integer> orders = new HashMap<>();

                orders.put(arr[2], Integer.parseInt(arr[3]));
                cities.put(arr[1], orders);
                buyers.put(arr[0], cities);

                continue;
            }

            HashMap<String, HashMap<String, Integer>> cities = buyers.get(arr[0]);
            if (!cities.containsKey(arr[1])) {
                HashMap<String, Integer> orders = new HashMap<>();

                orders.put(arr[2], Integer.parseInt(arr[3]));
                cities.put(arr[1], orders);

                continue;
            }

            HashMap<String, Integer> orders = cities.get(arr[1]);
            if (!orders.containsKey(arr[2])) {
                orders.put(arr[2], Integer.parseInt(arr[3]));

                continue;
            }

            int orderAmount = orders.get(arr[2]);
            orders.put(arr[2], Integer.parseInt(arr[3]) + orderAmount);
        }

        for (Map.Entry<String, HashMap<String, HashMap<String, Integer>>> mapOfBuyers : buyers.entrySet()) {
            System.out.println(mapOfBuyers.getKey() + ":");
            HashMap<String, HashMap<String, Integer>> cities = mapOfBuyers.getValue();
            for (Map.Entry<String, HashMap<String, Integer>> mapOfCities : cities.entrySet()) {
                System.out.println("\t"+ mapOfCities.getKey() + ":");
                HashMap<String, Integer> orders = mapOfCities.getValue();
                for (Map.Entry<String, Integer> mapOfOrders : orders.entrySet()) {
                    System.out.println("\t\t"+ mapOfOrders.getKey() + " - " + mapOfOrders.getValue());
                }
            }
        }
    }
}

package Homework2503;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static void printAll(HashMap<String, Integer> hashMap) {
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void addElement(HashMap<String, Integer> hashMap, String name, int amount) {
        hashMap.put(name, amount);
        try(FileWriter writer = new FileWriter("C:/Git/GizetdinovA_11005/Java/Homework2503/ProductList.txt", false))
        {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String text = entry.getKey() + ":" + entry.getValue() + "\n";
                writer.write(text);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void deleteElement(HashMap<String, Integer> hashMap, String name) {
        hashMap.remove(name);
        try(FileWriter writer = new FileWriter("C:/Git/GizetdinovA_11005/Java/Homework2503/ProductList.txt", false))
        {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String text = entry.getKey() + ":" + entry.getValue() + "\n";
                writer.write(text);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void changeElement(HashMap<String, Integer> hashMap, String name, int amount) {
        hashMap.put(name, hashMap.get(name) + amount);
        try(FileWriter writer = new FileWriter("C:/Git/GizetdinovA_11005/Java/Homework2503/ProductList.txt", false))
        {
            String text = name + ":" + hashMap.get(name) + "\n";
            writer.write(text);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            File file = new File("C:/Git/GizetdinovA_11005/Java/Homework2503/ProductList.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String arrOfStr[] = str.split(":");
                hashMap.put(arrOfStr[0], Integer.parseInt(arrOfStr[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        printAll(hashMap);
        changeElement(hashMap, "Juice", 5);
        changeElement(hashMap, "Water", 13);
        addElement(hashMap, "Latte", 23);
        addElement(hashMap, "Americano", 46);
        deleteElement(hashMap, "Coffee");
        printAll(hashMap);
    }
}

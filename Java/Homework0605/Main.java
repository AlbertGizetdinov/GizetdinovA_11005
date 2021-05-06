package Homework0605;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(Comparator.comparingInt(String::length));
        treeSet.add("two");
        treeSet.add("twenty one");
        treeSet.add("eight");
        treeSet.add("0");
        System.out.println("First task:\n" + treeSet);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1024);
        arrayList.add(-1);
        arrayList.add(0);
        arrayList.add(1337);
        arrayList.add(-128);

        ArrayList<Integer> evenNumbers = arraySorting(arrayList, x -> x % 2 == 0);
        ArrayList<Integer> positiveNumbers = arraySorting(arrayList, x -> x > 0);
        System.out.println("Second task: " +
                "\n1) Even numbers: " + evenNumbers +
                "\n2) Positive numbers: " + positiveNumbers);
    }

    public static ArrayList<Integer> arraySorting(ArrayList<Integer> arr, Predicate<Integer> predicate) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : arr) {
            if (predicate.test(x))
                result.add(x);
        }
        return result;
    }

}

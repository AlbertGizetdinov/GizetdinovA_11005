package Homework2202;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[6];
        for (int i : new Range(a.length)) {
            a[i] = sc.nextInt();
        }
        for (int i : new Range(a.length)) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
        while (true) {
            try {
                System.out.println("Enter number smaller than: " + a.length);
                int num = sc.nextInt();
                for (int i : new RangeInterval(num, a.length)) {
                    System.out.print(a[i] + "\t");
                }
                break;
            } catch (Exception e) {
                System.out.println("NullPointerException");
            }
        }
        System.out.println();
        for(int i : new FibonacciRange(sc.nextInt())) {
            System.out.print(i + "\t");
        }
    }
}

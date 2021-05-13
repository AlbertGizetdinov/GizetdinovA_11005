package Homework1305;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("First task");
        String[] strArr = {"abcdef", "sdk", "a", "qwe", "rtyp", "ajs", "ab", "slkdglfs", "asdwwssdww"};
        Stream<String> stream1 = Arrays.stream(strArr)
                .filter(str -> str.charAt(0) == 'a')
                .sorted(Comparator.comparingInt(String::length));
        stream1.forEach(System.out::println);

        System.out.println("\nSecond task");
        Stream<Integer> stream2 = Stream.of(231, 312, 123, 231, 323, 123, 123);
        stream2.sorted(Comparator.comparingInt(x -> x % 10))
                .map(x -> x / 10)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\nThird task");
        FileReader fileReader = new FileReader("C://Git/GizetdinovA_11005/Java/Homework1305/task3.txt");
        Scanner sc = new Scanner(fileReader);
        String[] s = new String[100];
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
        System.out.println(map);
    }
}
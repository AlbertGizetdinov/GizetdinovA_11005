package Classwork1905;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IllegalStateException {
        //Найти сумму длин всех строк, входящих в данную последовательность.
        System.out.println("First Task");
        String[] arrStr = {"ab1", "sd0", "a", "qw2", "rt0", "aj04", "aa9", "ab", "ee5"}; // 3+3+1+3+3+4+3+2+3=25
        Stream<String> firstTask = Arrays.stream(arrStr);
        System.out.println("Length of all strings is: " + firstTask
                .map(x -> x.length())
                .reduce(0, Integer::sum));

        //Найти количество ее отрицательных элементов, а также их сумму.
        System.out.println("\nSecond task");
        Integer[] arrInt = {1, 0, -2, 35, 9, -18, 12, 99, 25, 0, -5};
        Stream<Integer> secondTask = Arrays.stream(arrInt).filter(x -> x < 0);
        System.out.println("Sum of all negative numbers: " + secondTask.reduce(0, Integer::sum));

        //Извлечь из нее все положительные числа, сохранив их исходный порядок следования.
        System.out.println("\nThird task");
        Stream<Integer> thirdTask = Arrays.stream(arrInt);
        List<Integer> listThirdTask = thirdTask
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        System.out.println(listThirdTask);

        //Извлечь из нее все положительные двузначные числа, отсортировав их по возрастанию.
        System.out.println("\nFourth task");
        Stream<Integer> fourthTask = Arrays.stream(arrInt);
        List<Integer> listFourthTask = fourthTask
                .filter(x -> x > 0 && x % 10 != 0 && x / 100 == 0)
                .sorted(Integer::compare)
                .collect(Collectors.toList());
        System.out.println(listFourthTask);

        //Извлечь из A все строки длины K, оканчивающиеся цифрой, отсортировав их в лексикографическом порядке по возрастанию.
        System.out.println("\nFifth task");
        int k = 3;
        Stream<String> fifthTask = Arrays.stream(arrStr);
        List<String> listFifthTask = fifthTask
                .filter(x -> x.length() == k && x.charAt(k - 1) >= '0' && x.charAt(k - 1) <= '9')
                .sorted((a,b) -> String.CASE_INSENSITIVE_ORDER.compare(a,b))
                .collect(Collectors.toList());
        System.out.println(listFifthTask);
    }
}
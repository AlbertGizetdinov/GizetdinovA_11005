package Homework0803;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Задача 1: проверка правильности расставленных скобок
        Brackets brackets = new Brackets();
        brackets.checkBrackets(sc.nextLine());
        //Задача 2: калькулятор в обратной польской нотации
        Calculator calc = new Calculator();
        calc.startCalculator(sc.nextLine());
    }
}

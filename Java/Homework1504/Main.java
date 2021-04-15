package Homework1504;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        MathBot bot = new MathBot();
        System.out.println("-> Введите команду:\n" +
                "-> *Чтобы увидеть список доступных команд введдите: help*\n" +
                "-> *Чтобы закончить беседу введите: exit*");
        while (true) {
            System.out.print("-> ");
            String message = sc.nextLine();
            if (message.equals("exit")) {
                System.out.println("-> *Завершение работы бота*");
                break;
            }
            String answer = bot.userMessage(message);
            System.out.println(answer);
        }

    }
}

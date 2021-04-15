package Homework1504;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class MathBot {
    private static final HashMap<String, Method> commands = new HashMap<>();
    private String[] splitStr;
    private static String answer;

    public MathBot() {
        for(Method m : this.getClass().getDeclaredMethods()){
            if(!m.isAnnotationPresent(Command.class)){
                continue;
            }
            Command cmd = m.getAnnotation(Command.class);
            if(cmd.inProgress()){
                continue;
            }
            commands.put(cmd.name().toLowerCase(), m);
            for(String name : cmd.commands()){
                commands.put(name.toLowerCase(), m);
            }
        }
    }

    public String userMessage(String message) throws InterruptedException {
        if (message.isEmpty())
            return "-> Напишите что-нибудь";

        String[] args = new String[]{};

        String command = message.toLowerCase();
        if(commands.get(command) == null){
            splitStr = command.split(" ");
            command = splitStr[0].toLowerCase();
            args = Arrays.copyOfRange(splitStr, 1, splitStr.length);
        }

        Method m = commands.get(command);

        try {
            String answer = (String) m.invoke(this, (Object) args);
            if(m.isAnnotationPresent(Command.class)){
                Command cmd = m.getAnnotation(Command.class);
                String name = cmd.name().toLowerCase();
            }
            return answer;
        } catch (Exception e) {
            return "-> Что-то пошло не так, попробуйте ещё раз";
        }

    }

    @Command(id = 1, inProgress = false, name = "Команды", commands = {"help", "commands", "помощь"})
    public String getInfo(String[] args) {
        StringBuilder builder = new StringBuilder("-> Команды:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class)) {
                continue;
            }
            Command cmd = m.getAnnotation(Command.class);
            builder.append(cmd.name()).append(": ").append(Arrays.toString(cmd.commands())).append(cmd.example()).append("\n");
        }

        return builder.toString();
    }

    @Command(id = 2, inProgress = false, name = "Приветствие", commands = {"hello", "hi", "привет"})
    public String hello(String[] args) { return "-> Привет!"; }

    @Command(id = 3, inProgress = false, name = "Прощание", commands = {"goodbye", "bb", "пока"})
    public String goodbye(String[] args) { return "-> Пока!"; }

    @Command(id = 4, inProgress = false, name = "Факториал", commands = {"factorial", "fact", "факториал"}, example = "  Example: fact 3")
    public String fact(String[] args){
        int fact = Integer.valueOf(splitStr[1]);
        long facrotial = 1;
        while (fact > 0) {
            facrotial *= fact;
            fact--;
        }
        String res = "-> " + facrotial;
        return res;
    }

    @Command(id = 5, inProgress = false, name = "Сумма", commands = {"amount", "sum", "сложи"}, example = "  Example: sum 1 2")
    public String sum(String[] args){
        int sum = Integer.valueOf(splitStr[1]) + Integer.valueOf(splitStr[2]);
        String res = "-> " + sum;
        return res;
    }

    @Command(id = 6, inProgress = false, name = "Разность", commands = {"difference", "diff", "вычти"}, example = "  Example: diff 3 4")
    public String difference(String[] args){
        int diff = Integer.valueOf(splitStr[1]) - Integer.valueOf(splitStr[2]);
        String res = "-> " + diff;
        return res;
    }

    @Command(id = 7, inProgress = false, name = "Умножение", commands = {"multiplication", "mult", "умножь"}, example = "  Example: mult 5 6")
    public String multiplication(String[] args){
        int mult = Integer.valueOf(splitStr[1]) * Integer.valueOf(splitStr[2]);
        String res = "-> " + mult;
        return res;
    }

    @Command(id = 8, inProgress = false, name = "Деление", commands = {"division", "div", "раздели"}, example = "  Example: div 7 8")
    public String division(String[] args){
        float div = Float.valueOf(splitStr[1]) / Integer.valueOf(splitStr[2]);
        String res = "-> " + div;
        return res;
    }

    @Command(id = 9, inProgress = false, name = "Возведение в степень", commands = {"degree", "deg", "возведи"}, example = "  Example: deg 9 0")
    public String degree(String[] args){
        int num = Integer.valueOf(splitStr[1]);
        int degree = Integer.valueOf(splitStr[2]);
        int result = 1;
        while (degree > 0) {
            result *= num;
            degree--;
        }
        String res = "-> " + result;
        return res;
    }
}
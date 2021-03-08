package Homework0803;

import java.util.Stack;

public class Calculator {
    private Stack<Integer> stack = new Stack<>();
    private String str;

    private Boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public void startCalculator(String str) {
        stack.push(null);
        this.str = str;
        int x;
        int y;
        int res;
        try {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' '){
                    continue;
                }
                String string = String.valueOf(str.charAt(i));
                if (tryParseInt(string)) {
                    int a = Integer.parseInt(string);
                    stack.push(a);
                } else {
                    switch (string) {
                        case "+":
                            x = stack.pop();
                            y = stack.pop();
                            stack.push(x + y);
                            break;
                        case "-":
                            x = stack.pop();
                            y = stack.pop();
                            stack.push(x - y);
                            break;
                        case "*":
                            x = stack.pop();
                            y = stack.pop();
                            stack.push(x * y);
                            break;
                        case "/":
                            x = stack.pop();
                            y = stack.pop();
                            stack.push(x / y);
                            break;
                    }
                }
            }
            res = stack.pop();
            if (stack.pop() != null) {
                res = 0;
            }
        } catch (Exception e) {
            System.out.println("Too many operations");
            return;
        }
        System.out.println(res);
    }
}

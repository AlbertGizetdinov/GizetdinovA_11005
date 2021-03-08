package Homework0803;
import java.util.Stack;

public class Brackets {
    private Stack<String> stack = new Stack<>();
    private String str;

    public void checkBrackets(String str) {
        stack.push(null);
        this.str = str;
        Boolean bool = true;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)){
                case '(':
                    stack.push("(");
                    break;
                case '[':
                    stack.push("[");
                    break;
                case '{':
                    stack.push("{");
                    break;
                case ')':
                    if (stack.peek() == "("){
                        stack.pop();
                    } else {
                        bool = false;
                    }
                    break;
                case ']':
                    if (stack.peek() == "["){
                        stack.pop();
                    } else {
                        bool = false;
                    }
                    break;
                case '}':
                    if (stack.peek() == "{"){
                        stack.pop();
                    } else {
                        bool = false;
                    }
                    break;
            }
        }
        if (bool) {
            System.out.println("You have all brackets");
        } else {
            System.out.println("You are missing some brackets");
        }
    }
}

package Homework0103;

public class Main {
    public static void main(String[] args) {
        //First task
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.peek()); // 7
        System.out.println(stack.pop()); // 7
        System.out.println(stack.pop()); // 6
        System.out.println(stack.peek()); // 5
        stack.push(7);
        System.out.println();

        //Second task
        for (Integer value : stack) {
            System.out.print(value + "\t"); // 7, 5
        }
        System.out.println("\n");

        //Third task
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(12);
        for (int i = 1; i <= 6; i++) {
            System.out.print(list.get(i) + "\t"); // 2, 4, 6, 8, 10, 12
        }
        System.out.println("\n");
        System.out.println(list.get(2)); // 4
        System.out.println(list.get(5)); // 10
        System.out.println();
        System.out.println(list.count()); // 6
        list.remove(3);
        list.remove(3);
        System.out.println();
        for (int i = 1; i <= 4; i++) {
            System.out.print(list.get(i) + "\t"); // 2, 4, 10, 12
        }
        System.out.println("\n\n" + list.count() + "\n"); // 4

        //Fourth task
        for (Integer value : list) {
            System.out.print(value + "\t");
        }
    }
}

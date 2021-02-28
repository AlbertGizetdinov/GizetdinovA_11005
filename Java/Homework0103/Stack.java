package Homework0103;
import java.util.Iterator;

public class Stack<T> {
    static class Node<T> {
        private T value;
        private Node<T> next = null;
    }

    private Node<T> head = null;

    void push(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        node.next = head;
        head = node;
    }

    T pop() {
        if (head != null) {
            Node<T> temp = head;
            T res = temp.value;
            head = temp.next;
            return res;
        } else {
            return null;
        }
    }

    T peek() {
        if (head != null) {
            return head.value;
        } else {
            return null;
        }
    }

    StackIterator getIterator(){
        return new StackIterator();
    }

    public class StackIterator implements Iterable<T> {
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                int num = 0;
                Node<T> temp1 = head;

                @Override
                public boolean hasNext() {
                    if (temp1 == head) {
                        num++;
                    }
                    if (num == 2) {
                        num = 0;
                        return false;
                    }
                    return temp1 != null;
                }

                @Override
                public T next() {
                    Node<T> temp2 = temp1;
                    temp1 = temp2.next;
                    if (hasNext() == false) {
                        temp1 = head;
                    }
                    return temp2.value;
                }
            };
        }
    }
}

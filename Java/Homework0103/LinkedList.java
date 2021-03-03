package Homework0103;
import java.util.Iterator;

public class LinkedList<T> {
    static class Node<T> {
        private T value;
        private Node<T> next = null;
    }

    Node<T> head = null;
    Node<T> last = null;
    int count = 0;

    void add(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        if (head == null) {
            node.next = null;
            head = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        count++;
    }

    T get(int i) {
        Node<T> node = head;
        i--;
        while (i > 0) {
            i--;
            node = node.next;
        }
        return node.value;
    }

    int count() {
        return count;
    }

    void remove(int i) {
        Node<T> nodePrev = head;
        i = i - 2;
        while (i > 0) {
            i--;
            nodePrev = nodePrev.next;
        }
        Node<T> node = nodePrev.next;
        nodePrev.next = node.next;
        count--;
    }

    ListIterator getIterator(){
        return new ListIterator();
    }

    public class ListIterator implements Iterable<T> {
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Node<T> node = head;
                int num = count;;

                @Override
                public boolean hasNext() {
                    return num > 0;
                }

                @Override
                public T next() {
                    Node<T> temp = node;
                    node = temp.next;
                    if (hasNext() == false) {
                        node = head;
                    }
                    num--;
                    return temp.value;
                }
            };
        }
    }
}
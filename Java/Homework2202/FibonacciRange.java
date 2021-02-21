package Homework2202;
import java.util.Iterator;

public class FibonacciRange implements Iterable<Integer> {
    protected int first;
    protected int second;
    protected int third;
    protected int length;

    public FibonacciRange(int length) {
        second = 0;
        third = 1;
        this.length = length;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return 0 < length;
            }

            @Override
            public Integer next() {
                length--;
                first = second;
                second = third;
                third = first + second;
                return first;
            }
        };
    }

}

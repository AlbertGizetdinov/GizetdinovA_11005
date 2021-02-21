package Homework2202;

public class ThreeTuple<A, B, C> extends Tuple<A, B> {
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }
}

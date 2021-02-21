package Homework2202;

public class RangeInterval extends Range {

    public RangeInterval (int start, int end) {
        super(end > start ? end : null);
        this.counter = start;
    }
}

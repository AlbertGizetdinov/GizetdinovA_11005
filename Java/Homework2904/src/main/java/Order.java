import java.io.Serializable;

public class Order implements Serializable {
    public String name;
    public int amount;

    public Order(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

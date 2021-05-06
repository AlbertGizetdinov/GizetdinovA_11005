import java.util.ArrayList;

public class OrdersTimeSaver implements OrdersSaver {
    public ArrayList<Order> orders = new ArrayList<>();

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public void saveOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}

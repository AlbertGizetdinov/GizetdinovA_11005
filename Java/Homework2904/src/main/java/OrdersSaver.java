import java.util.ArrayList;

public interface OrdersSaver {
    ArrayList<Order> getOrders();
    void saveOrders(ArrayList<Order> orders);
}

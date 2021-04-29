import java.util.List;

public interface OrdersSaver {
    List<Order> getOrders();
    void saveOrders(List<Order> orders);
}

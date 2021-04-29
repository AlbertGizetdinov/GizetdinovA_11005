import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class StorageToFileTests {
    private Storage storage;
    private ArrayList<Order> orders;

    @Before
    public void prepareProducts() {
        orders = new ArrayList<>();
        orders.add(new Order("chair", 10));
        orders.add(new Order("table", 5));
        OrdersFileSaver saver = new OrdersFileSaver("orders.txt");
        saver.saveOrders(orders);
        storage = new Storage(saver);
    }

    @Test
    public void readToWarehouseTest() {
        assertEquals(orders.size(), storage.orderList.size());
        for (int i = 0; i < orders.size(); i++) {
            assertEquals(orders.get(i).name, storage.orderList.get(i).name);
            assertEquals(orders.get(i).amount, storage.orderList.get(i).amount);
        }
    }

    @Test
    public void addOrderTest() {
        orders.add(new Order("phone", 15));
        storage.addOrder("phone", 15);
        List<Order> temp = storage.orderSaver.getOrders();
        assertEquals(orders.size(), temp.size());
        for (int i = 0; i < orders.size(); i++) {
            assertEquals(orders.get(i).name, temp.get(i).name);
            assertEquals(orders.get(i).amount, temp.get(i).amount);
        }
    }
}

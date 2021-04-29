import org.junit.*;
import static org.junit.Assert.*;

public class StorageTests {
    private Storage storage;
    private OrdersTimeSaver saver;

    @Before
    public void prepareOrders() {
        saver = new OrdersTimeSaver();
        saver.orders.add(new Order("chair", 10));
        saver.orders.add(new Order("table", 5));
        storage = new Storage(saver);
    }

    @Test
    public void addOrdersTest() {
        storage.addOrder("phone", 15);
        assertEquals(3, saver.orders.size());
        assertEquals("phone", saver.orders.get(2).name);
        assertEquals(15, saver.orders.get(2).amount);
    }

    @Test
    public void getOrderTestSucceed() {
        Order order = storage.getOrder("table");
        assertNotNull(order);
        assertEquals("table", order.name);
        assertEquals(5, order.amount);
    }

    @Test
    public void getOrderTestFailed() {
        Order order = storage.getOrder("phone");
        assertNull(order);
    }

    @Test
    public void removeOrderTestSucceed() {
        storage.removeOrder("table");
        assertEquals(1, saver.orders.size());
    }

    @Test
    public void removeOrderTestFailed() {
        Order order = storage.getOrder("phone");
        assertNull(order);
    }

    @Test
    public void changeQuantityTestSucceed() {
        Order order = storage.getOrder("chair");
        order.setAmount(5);
        assertEquals(5, order.amount);
    }

    @Test
    public void changeQuantityTestFailed() {
        Order order = storage.getOrder("phone");
        assertNull(order);
    }
}

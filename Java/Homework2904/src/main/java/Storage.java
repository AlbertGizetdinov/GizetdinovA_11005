import java.util.Iterator;
import java.util.List;

public class Storage {
    public OrdersSaver orderSaver;
    public List<Order> orderList;

    public Storage(OrdersSaver orderSaver) {
        this.orderSaver = orderSaver;
        this.orderList = orderSaver.getOrders();
    }

    public void addOrder(String name, int count) {
        Order order = new Order(name, count);
        this.orderList.add(order);
        this.orderSaver.saveOrders(this.orderList);
    }

    public Order getOrder(String name) {
        Iterator var = this.orderList.iterator();
        Order order;
        do {
            if (!var.hasNext()) {
                return null;
            }
            order = (Order) var.next();
        } while(!order.name.equals(name));
        return order;
    }

    public void removeOrder(String name) {
        Order p = this.getOrder(name);
        if (p != null) {
            this.orderList.remove(p);
        }
        this.orderSaver.saveOrders(this.orderList);
    }

    public void changeQuantity(String name, int quantity) {
        Order order = this.getOrder(name);
        if (order != null) {
            order.setAmount(quantity);
        }
        this.orderSaver.saveOrders(this.orderList);
    }

    public void printAll() {
        for (Order order : this.orderList) {
            System.out.println(order.name + ": " + order.amount);
        }
    }
}
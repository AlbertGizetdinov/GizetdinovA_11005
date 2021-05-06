import java.util.Iterator;
import java.util.ArrayList;

public class Storage {
    public OrdersSaver orderSaver;
    public ArrayList<Order> orderList;
    public ArrayList<ProductsListener> productListenersList = new ArrayList<>();

    public void addProductsListener(ProductsListener productsListener) {
        if (!productListenersList.contains(productsListener))
            productListenersList.add(productsListener);
    }

    public Storage(OrdersSaver orderSaver) {
        this.orderSaver = orderSaver;
        orderList = orderSaver.getOrders();
    }

    public void addOrder(String name, int count) {
        Order order = new Order(name, count);
        this.orderList.add(order);
        this.orderSaver.saveOrders(this.orderList);
        for (ProductsListener listener : productListenersList) listener.productsUpdated();
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
        for (ProductsListener listener : productListenersList) listener.productsUpdated();
    }

    public void changeQuantity(String name, int quantity) {
        Order order = this.getOrder(name);
        if (order != null) {
            order.setAmount(quantity);
        }
        this.orderSaver.saveOrders(this.orderList);
        for (ProductsListener listener : productListenersList) listener.productsUpdated();
    }

    public void printAll() {
        for (Order order : this.orderList) {
            System.out.println(order.name + ": " + order.amount);
        }
    }
}
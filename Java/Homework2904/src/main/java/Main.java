public class Main {
    public static void main(String[] args) {
        OrdersFileSaver fileSaver = new OrdersFileSaver("Orders.txt");
        Storage storage = new Storage(fileSaver);
        storage.addOrder("chair", 10);
        storage.addOrder("table", 5);
        storage.changeQuantity("table", 2);
        storage.removeOrder("chair");
        storage.printAll();
    }
}
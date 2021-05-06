public class Main {
    public static void main(String[] args) {
        OrdersFileSaver fileSaver = new OrdersFileSaver("Orders.txt");
        Storage storage = new Storage(fileSaver);

        storage.addProductsListener(storage::printAll);
        storage.addProductsListener(() -> {
            int result = 0;
            for (Order o : storage.orderList) result += o.getAmount();
            System.out.println("Number of occupied places: " + result);
        });
        storage.addProductsListener(() -> {
            int max = 0;
            String res = "-";
            for (int i = 0; i < storage.orderList.size(); i++) {
                if (storage.orderList.get(i).getAmount() > max) {
                    max = storage.orderList.get(i).getAmount();
                    res = storage.orderList.get(i).name;
                }
            }
            System.out.println("The largest number of product: " + res + "\n");
        });
        
        storage.addOrder("chair", 10);
        storage.addOrder("table", 5);
        storage.changeQuantity("table", 2);
        storage.removeOrder("chair");
        storage.printAll();
    }
}
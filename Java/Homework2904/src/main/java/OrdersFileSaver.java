import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdersFileSaver implements OrdersSaver {
    private File file;

    public OrdersFileSaver(File file) {
        this.file = file;
    }

    public OrdersFileSaver(String fileName) {
        file = new File(fileName);
    }

    @Override
    public List<Order> getOrders() {
        List<Order> listOfOrders = new ArrayList<>();
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))) {
            Order[] temp = (Order[]) oin.readObject();
            listOfOrders.addAll(Arrays.asList(temp));
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listOfOrders;
    }

    @Override
    public void saveOrders(List<Order> orders) {
        try (ObjectOutputStream oin = new ObjectOutputStream(new FileOutputStream(file))) {
            Order[] temp = new Order[orders.size()];
            for (int i = 0; i < orders.size(); i++) {
                temp[i] = orders.get(i);
            }
            oin.writeObject(temp);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
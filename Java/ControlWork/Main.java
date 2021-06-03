package ControlWork;

import java.util.*;
import java.io.*;

class Buyer {
    String name;
    String city;

    public Buyer(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

class Discount {
    String shopName;
    String buyerName;
    int discount;

    public Discount(String shopName, String buyerName, int discount) {
        this.shopName = shopName;
        this.buyerName = buyerName;
        this.discount = discount;
    }
}

class Product {
    String shopName;
    String productName;
    int price;

    public Product(String shopName, String productName, int price) {
        this.shopName = shopName;
        this.productName = productName;
        this.price = price;
    }
}

class Purchase {
    String buyerName;
    String shopName;
    String productName;

    public Purchase(String buyerName, String shopName, String productName) {
        this.buyerName = buyerName;
        this.shopName= shopName;
        this.productName = productName;
    }
}

public class Main {

    public static void main(String[] args) throws Exception{
        ArrayList<Buyer> buyersList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("buyers.txt"));
        String str;

        while ((str = bufferedReader.readLine()) != null) {
            String[] splitStr = str.split("\\|");
            String name = splitStr[0];
            String city = splitStr[1];
            buyersList.add(new Buyer(name, city));
        }

        ArrayList<Discount> discountList = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader("discounts.txt"));

        while ((str = bufferedReader.readLine()) != null) {
            String[] splitStr = str.split("\\|");
            String shopName = splitStr[0];
            String buyerName = splitStr[1];
            Integer discount = Integer.parseInt(splitStr[2]);
            discountList.add(new Discount(shopName, buyerName, discount));
        }

        ArrayList<Product> productList = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader("products.txt"));

        while ((str = bufferedReader.readLine()) != null) {
            String[] splitStr = str.split("\\|");
            String shopName = splitStr[0];
            String productName = splitStr[1];
            Integer price = Integer.parseInt(splitStr[2]);
            productList.add(new Product(shopName, productName, price));
        }

        ArrayList<Purchase> purchaseList = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader("products.txt"));

        while ((str = bufferedReader.readLine()) != null) {
            String[] splitStr = str.split("\\|");
            String buyerName = splitStr[0];
            String shopName = splitStr[1];
            String productName = splitStr[2];
            purchaseList.add(new Purchase(buyerName, shopName, productName));
        }

        HashMap<String, HashMap<String, HashMap<String, Integer>>> buyers = new HashMap<>();
        for (Buyer entry1 : buyersList) {
            if (!buyers.containsKey(entry1.name)) {
                HashMap<String, HashMap<String, Integer>> cities = new HashMap<>();
                HashMap<String, Integer> products = new HashMap<>();
                for (Discount entry2 : discountList) {
                    if (entry2.buyerName == entry1.name) {
                        for (Product entry3 : productList) {
                            if (entry3.shopName == entry2.shopName) {
                                for (Purchase entry4 : purchaseList) {
                                    if (entry4.buyerName == entry1.name && entry4.shopName == entry2.shopName && entry4.productName == entry3.productName) {
                                        products.put(entry4.productName, products.get(entry3.productName) + entry3.price * (100 - entry2.discount) / 100);
                                    }
                                }
                            }
                        }
                    }
                }
                cities.put(entry1.city, products);
                buyers.put(entry1.name, cities);

                continue;
            }

            HashMap<String, HashMap<String, Integer>> cities = buyers.get(entry1.name);
            if (!cities.containsKey(entry1.city)) {
                HashMap<String, Integer> products = new HashMap<>();
                for (Discount entry2 : discountList) {
                    if (entry2.buyerName == entry1.name) {
                        for (Product entry3 : productList) {
                            if (entry3.shopName == entry2.shopName) {
                                for (Purchase entry4 : purchaseList) {
                                    if (entry4.buyerName == entry1.name && entry4.shopName == entry2.shopName && entry4.productName == entry3.productName) {
                                        products.put(entry4.productName, products.get(entry3.productName) + entry3.price * (100 - entry2.discount) / 100);
                                    }
                                }
                            }
                        }
                    }
                }
                cities.put(entry1.city, products);

                continue;
            }

            HashMap<String, Integer> products = cities.get(entry1.city);
            for (Discount entry2 : discountList) {
                if (entry2.buyerName == entry1.name) {
                    for (Product entry3 : productList) {
                        if (entry3.shopName == entry2.shopName) {
                            for (Purchase entry4 : purchaseList) {
                                if (entry4.buyerName == entry1.name && entry4.shopName == entry2.shopName && entry4.productName == entry3.productName) {
                                    products.put(entry4.productName, products.get(entry3.productName) + entry3.price * (100 - entry2.discount) / 100);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (Map.Entry<String, HashMap<String, HashMap<String, Integer>>> entry1 : buyers.entrySet()) {
            HashMap<String, HashMap<String, Integer>> cities = entry1.getValue();
            for (Map.Entry<String, HashMap<String, Integer>> entry2 : cities.entrySet()) {
                int S = 0;
                HashMap<String, Integer> products = entry2.getValue();
                for (Map.Entry<String, Integer> entry3 : products.entrySet()) {
                    S += entry3.getValue();
                }
                System.out.println(entry2.getKey() + ":" + S);
            }
        }
    }
}

package adapter;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Main {
    public static void main(String[] args) {
        List<Costable> products = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            products.add(Repository.getProduct());
        }
        int sum = Calculator.calcAll(products);
        System.out.println("sum = " + sum);
    }
}

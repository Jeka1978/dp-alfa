package adapter;

import java.util.Random;

/**
 */
public class Repository {
    public static Costable getProduct(){
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            return new Chair();
        }else {
            return new Car();
        }

    }
}

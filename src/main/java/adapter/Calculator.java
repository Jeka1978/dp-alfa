package adapter;


import java.util.List;

/**
 */
public class Calculator {
    public static int calcAll(List<Pricable> pricables) {
        return pricables.parallelStream().mapToInt(Pricable::getPrice).sum();
    }
}

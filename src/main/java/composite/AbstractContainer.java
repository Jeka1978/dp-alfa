package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 21/07/2016.
 */
public abstract class AbstractContainer implements Container {
    private List<Priceable> priceables = new ArrayList<>();
    private int myPrice;

    public AbstractContainer(int myPrice) {
        this.myPrice = myPrice;
    }

    @Override
    public void add(Priceable priceable) {
        priceables.add(priceable);
    }

    @Override
    public int getPrice() {
        int sum = priceables.parallelStream().mapToInt(Priceable::getPrice).sum();
        return sum+myPrice;
    }
}








package composite;

import lombok.AllArgsConstructor;

/**
 * Created by Evegeny on 21/07/2016.
 */
@AllArgsConstructor
public class Book implements Priceable {
    private int price;

    @Override
    public int getPrice() {
        return price;
    }
}

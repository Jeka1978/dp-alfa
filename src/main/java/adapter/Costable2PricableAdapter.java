package adapter;

import lombok.RequiredArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
public class Costable2PricableAdapter implements Pricable {
    private final Costable costable;

    @Override
    public int getPrice() {
        return costable.getCost();
    }
}

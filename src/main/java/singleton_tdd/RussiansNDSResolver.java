package singleton_tdd;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 */
public class RussiansNDSResolver implements NDSResolver {

    private double nds;


    @SneakyThrows
    public RussiansNDSResolver() {
        Thread.sleep(1000);
        nds = 0.19;
    }


    @Override
    public double getNDS() {
        return nds;
    }


















}

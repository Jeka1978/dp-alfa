package singleton_tdd;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */
public class TaxCalc {

    @Autowired
    private NDSResolver ndsResolver;

    public TaxCalc(NDSResolver ndsResolver) {
        this.ndsResolver = ndsResolver;
    }

    public double withNDS(double price) {
        return price *ndsResolver.getNDS()+price;
    }

    
}

package singleton_tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class TaxCalcTest {
    @Test
    public void withNDS() throws Exception {
        NDSResolver ndsResolverMock = Mockito.mock(NDSResolver.class);
        Mockito.when(ndsResolverMock.getNDS()).thenReturn(0.1);
        TaxCalc taxCalc = new TaxCalc(ndsResolverMock);

        double withNDS = taxCalc.withNDS(100);

        Assert.assertEquals(110,withNDS,0.00001);
    }

}
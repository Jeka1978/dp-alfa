package my_spring;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ElfTest {
    @Test
    public void testInjectRandomIntIsSupportedByObjectFactory() throws Exception {
        Elf elf = ObjectFactory.getInstance().createObject(Elf.class);
        Assert.assertFalse(elf.getSpeed()==0);
        Assert.assertFalse(elf.getPower()==0);
    }
}
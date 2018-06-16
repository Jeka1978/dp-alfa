package composite;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class AbstractContainerTest {
    @Test
    public void getPrice() throws Exception {
        Book book = new Book(10);
        Book book2 = new Book(20);
        Shelf shelf = new Shelf(100);
        shelf.add(book);
        shelf.add(book2);
        Cupboard cupboard = new Cupboard(1000);
        cupboard.add(shelf);
        Assert.assertEquals(1130,cupboard.getPrice());
        Assert.assertEquals(130,shelf.getPrice());

    }

}
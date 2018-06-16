package reflections_example;

import org.junit.Test;

/**
 * @author Evgeny Borisov
 */
public class Test1 {

    public Test1() {
        System.out.println("test object was created...");
    }


    @Test
    public void test1(){
        System.out.println("111111111111");
    }

    @Test
    public void test2(){
        System.out.println("222222222222");
    }
}

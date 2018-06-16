package my_spring;

/**
 * @author Evgeny Borisov
 */
public class PowerCleaner implements Cleaner {

    @InjectRandomInt(min=3, max = 6)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("FSHHSSSSSSSSsssssssssss");
        }
    }
}

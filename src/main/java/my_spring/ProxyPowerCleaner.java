package my_spring;

/**
 * @author Evgeny Borisov
 */
public class ProxyPowerCleaner implements Cleaner {
    @InjectByType
    private PowerCleaner powerCleaner;

    @Override
    public void clean() {
        long start = System.nanoTime();
        powerCleaner.clean();
        long end = System.nanoTime();
        System.out.println(end-start);
    }
}

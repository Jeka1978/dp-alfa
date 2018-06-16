package my_spring;

/**
 * @author Evgeny Borisov
 */
public class AlfaServiceImpl  {
//    @Override
    public void doWork() {
        System.out.println("Работаю неспеша...");
    }

//    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Жигулёвское forever!!!");
    }
}

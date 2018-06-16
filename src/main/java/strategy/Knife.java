package strategy;

/**
 * @author Evgeny Borisov
 */
public class Knife implements Weapon {
    @Override
    public void fight() {
        System.out.println("Бью ножом!!!");
    }
}

package strategy;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        King king = new King();
        king.fight();
        king.fight();
        king.fight();
        king.fight();
        king.setWeapon(new Knife());
        king.fight();
        king.fight();
        king.fight();
        king.fight();
    }
}

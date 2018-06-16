package strategy;

/**
 * @author Evgeny Borisov
 */
public class Son implements Mother,Father {
    @Override
    public void speak() {
        Mother.super.speak();
        Father.super.speak();
    }
}

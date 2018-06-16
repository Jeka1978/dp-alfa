package reflections_example.zoo;

/**
 * @author Evgeny Borisov
 */
public class Bee implements Animal {
    @Override
    public void makeVoice() {
        System.out.println("trrrr");
    }
}

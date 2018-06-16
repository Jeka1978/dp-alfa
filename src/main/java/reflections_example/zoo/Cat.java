package reflections_example.zoo;

/**
 * @author Evgeny Borisov
 */
public class Cat implements Animal {
    @Override
    public void makeVoice() {
        System.out.println("maaaaaaaaaaaaaau");
    }
}

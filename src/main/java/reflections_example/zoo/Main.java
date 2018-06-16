package reflections_example.zoo;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        makeVoice(animalFactory);
    }

    private static void makeVoice(AnimalFactory animalFactory) {
        animalFactory.getRandom().makeVoice();
        animalFactory.getRandom().makeVoice();
        animalFactory.getRandom().makeVoice();
        animalFactory.getRandom().makeVoice();
        animalFactory.getRandom().makeVoice();
    }
}

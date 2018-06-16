package reflections_example.zoo;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class AnimalFactory {


    private Random random = new Random();
    private ArrayList<Class<? extends Animal>> animalClasses;

    public AnimalFactory() {
        Reflections scanner = new Reflections("reflections_example.zoo");
        animalClasses = new ArrayList<>(scanner.getSubTypesOf(Animal.class));
    }

    @SneakyThrows
    public Animal getRandom() {
        Class<? extends Animal> animalClass = animalClasses.get(random.nextInt(animalClasses.size()));

        return animalClass.newInstance();



















    }
}

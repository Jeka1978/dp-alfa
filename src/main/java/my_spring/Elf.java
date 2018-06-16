package my_spring;

import lombok.Data;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 * @author Evgeny Borisov
 */
@Data
public class Elf {
    @InjectRandomInt(min = 12, max = 23)
    private int power;
    @InjectRandomInt(min = 28, max = 50)

    private int speed;


}

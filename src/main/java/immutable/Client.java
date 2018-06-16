package immutable;

import lombok.experimental.Wither;

/**
 * @author Evgeny Borisov
 */
@Wither
public class Client {
    private final String name;
    private final int age;
    private final int bonus;
    private final int debt;

    public Client(String name, int age, int bonus, int debt) {
        this.name = name;
        this.age = age;
        this.bonus = bonus;
        this.debt = debt;
    }
}

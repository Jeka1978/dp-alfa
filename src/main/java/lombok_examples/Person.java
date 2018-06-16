package lombok_examples;

import lombok.*;
import lombok.experimental.Wither;

/**
 * @author Evgeny Borisov
 */


@ToString(exclude = "age")
@EqualsAndHashCode(exclude = "age")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class Person {
    private String name;
    private int age;
    private int salary;

    private void init() {
        System.out.println("111111111111111111");
    }

    public void doX() {
        System.out.println("xxxxxxxxxxxx");
    }


}

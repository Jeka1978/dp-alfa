package lombok_examples;

import lombok.*;
import lombok.experimental.Wither;

/**
 * @author Evgeny Borisov
 */


@ToString(exclude = "age")
@EqualsAndHashCode(exclude = "age")
@Getter
@RequiredArgsConstructor
@Wither
public class Person {
    private final String name;
    private final int age;
    private final int salary;


}

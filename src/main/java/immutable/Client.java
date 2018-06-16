package immutable;

import lombok.*;
import lombok.experimental.Wither;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Wither
@Builder
@Value
public class Client {
    private final String name;
    private final int age;
    @NonNull
    private final Integer bonus;
    private  int debt=200;
    @Singular
    private Map<String,Integer> beers;
    @Singular("oneFish")
    private Map<String,Integer> fish;

}

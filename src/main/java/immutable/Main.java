package immutable;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Client jeka = Client.builder().age(39).bonus(200).name("jeka")
                .beer("Leff",9)
                .beer("Baltika",8)
                .oneFish("Karp",4)
                .build();
        System.out.println("jeka = " + jeka.withAge(40));
    }
}

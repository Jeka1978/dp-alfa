package strategy;

/**
 * @author Evgeny Borisov
 */
public interface Father {
   default void speak(){
       System.out.println("сын иди сюда");
   }
}

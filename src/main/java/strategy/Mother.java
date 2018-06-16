package strategy;

/**
 * @author Evgeny Borisov
 */
public interface Mother {
   default void speak(){
       System.out.println("СЫН СЮДА!!!");
   }
}

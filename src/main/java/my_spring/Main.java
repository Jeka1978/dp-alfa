package my_spring;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
//        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
//        iRobot.cleanRoom();
        AlfaServiceImpl alfaService = ObjectFactory.getInstance().createObject(AlfaServiceImpl.class);
        alfaService.doWork();
        alfaService.drinkBeer();
        System.out.println(alfaService.getClass());
    }
}

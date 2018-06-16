package reflections_example;

import lombok.SneakyThrows;
import lombok_examples.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Evgeny Borisov
 */
public class ReflectionUtils {



    @SneakyThrows
    public static void runAllTests(String className) {
        Class<?> type = Class.forName(className);
        runAllTests(type);
    }

    @SneakyThrows
    public static void runAllTests(Class type) {

        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Object o = type.newInstance();
//                int modifiers = method.getModifiers();
//                Modifier.isAbstract(modifiers)
                method.invoke(o);
            }
        }
    }

    @SneakyThrows
    public static void printApi(Object o) {
        Class<?> type = o.getClass();
        Method[] methods = type.getDeclaredMethods();
        Field[] fields = type.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

        for (Method method : methods) {
            System.out.println(method.getName());
            if (method.getName().startsWith("init")) {
                method.setAccessible(true);
                method.invoke(o);
            }
        }



    }


    public static void main(String[] args) {
       /* Person person = new Person();
        printApi(person);*/

        runAllTests("reflections_example.Test1");
    }


}

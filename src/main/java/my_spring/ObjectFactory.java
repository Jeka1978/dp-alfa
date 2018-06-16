package my_spring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections();
    private List<ObjectConfigurator> configurators = new ArrayList<>();



    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.newInstance());
            }
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        invokeInit(type, t);

        return t;


    }

    private <T> void invokeInit(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(type, method -> method.isAnnotationPresent(PostConstruct.class));
        for (Method method : methods) {
            method.setAccessible(true);
            method.invoke(t);
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator -> configurator.configure(t));
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> set = scanner.getSubTypesOf(type);
                if (set.size() != 1) {
                    throw new RuntimeException(type + " has 0 or more than one impl. Please update your config");
                }
                implClass = (Class<T>) set.iterator().next();
            }
            type = implClass;
        }
        return type;
    }


}

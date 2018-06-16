package my_spring;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object wrapWithProxy(Object t, Class type) {
        boolean methodNeedsBenchmark = Arrays.stream(type.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class));
        if (type.isAnnotationPresent(Benchmark.class)||methodNeedsBenchmark) {
            if (type.getInterfaces().length == 0) {
               return Enhancer.create(type, (org.springframework.cglib.proxy.InvocationHandler) (o, method, args) -> {
                    Method originalMethod = type.getMethod(method.getName(), method.getParameterTypes());
                    return createInvocationHandler(t, type, method, args, originalMethod);
                });
            }
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> {
                Method originalMethod = type.getMethod(method.getName(), method.getParameterTypes());
                return createInvocationHandler(t, type, method, args, originalMethod);
            });
        }else {
            return t;
        }
    }

    private Object createInvocationHandler(Object t, Class type, Method method, Object[] args, Method originalMethod) throws IllegalAccessException, InvocationTargetException {
        if (originalMethod.isAnnotationPresent(Benchmark.class)||type.isAnnotationPresent(Benchmark.class)) {
            System.out.println("**********BENCHMARK************"+method.getName()+"******* started");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end-start);
            System.out.println("**********BENCHMARK************"+method.getName()+"******* ended");
            return retVal;
        }else {
            return  method.invoke(t, args);
        }
    }
}

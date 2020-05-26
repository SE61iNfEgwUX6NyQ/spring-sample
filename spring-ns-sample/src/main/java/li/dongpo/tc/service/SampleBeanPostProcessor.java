package li.dongpo.tc.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

/**
 * dongpo.li
 * 2020/5/18
 */
public class SampleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
//        List<Method> methods = new ArrayList<>();
//        methods.addAll(Arrays.asList(clazz.getMethods()));

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(SampleAnnotation.class);
            if (annotation != null) {
                // 注册一个监听器
                try {
                    method.setAccessible(true);
                    method.invoke(bean, new HashMap<>());
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("执行错误");
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

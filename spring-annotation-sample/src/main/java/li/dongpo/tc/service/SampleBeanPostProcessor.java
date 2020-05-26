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

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(SampleAnnotation.class);
            if (annotation != null) {
                try {
                    // 开始执行这个有注解的方法
                    method.invoke(bean, new HashMap<>());
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("执行错误");
                }

//                throw new RuntimeException("这个是测试的，如果抛出异常，spring初始化就会停止，可以快速发现问题");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

package li.dongpo.tc.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SampleNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("sample", new BeanDefinitionParser() {
            @Override
            public BeanDefinition parse(Element element, ParserContext parserContext) {
                String name = element.getAttribute("name");
                String value = element.getAttribute("value");
                System.out.println("BeanDefinitionParser start, name=" + name + ", value=" + value);
                GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
                genericBeanDefinition.setBeanClassName(ThreadPoolExecutor.class.getCanonicalName());
//                Executors.newFixedThreadPool()
                ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
                constructorArgumentValues.addIndexedArgumentValue(0, 1);;
                constructorArgumentValues.addIndexedArgumentValue(1, 1);;
                constructorArgumentValues.addIndexedArgumentValue(2, 0L);;
                constructorArgumentValues.addIndexedArgumentValue(3, TimeUnit.MILLISECONDS);;
                constructorArgumentValues.addIndexedArgumentValue(4, new LinkedBlockingQueue<Runnable>());;
                genericBeanDefinition.setConstructorArgumentValues(constructorArgumentValues);

//                parserContext.getRegistry().registerBeanDefinition("executor", genericBeanDefinition);

                return genericBeanDefinition;
            }
        });
    }

}

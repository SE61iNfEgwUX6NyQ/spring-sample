package li.dongpo.tc;

import li.dongpo.tc.service.SampleServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: dongpo.li
 * Date: 2020-05-14
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("context初始化完成,开始获取bean");
        SampleServiceImpl sampleService = context.getBean(SampleServiceImpl.class);
        sampleService.hello();

    }
}

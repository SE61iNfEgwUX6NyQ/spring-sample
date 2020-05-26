package li.dongpo.tc;

import li.dongpo.tc.service.SampleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: dongpo.li
 * Date: 2020-05-14
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("context初始化完成,开始获取bean");
        SampleService sampleService0 = (SampleService) context.getBean("sampleService");
        sampleService0.hello();

        SampleService sampleService1 = context.getBean(SampleService.class);
        sampleService1.hello();

        ThreadPoolExecutor executor = context.getBean(ThreadPoolExecutor.class);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaaaaa");
            }
        });

        Thread.sleep(1000);
    }
}

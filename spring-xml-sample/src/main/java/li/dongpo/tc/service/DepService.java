package li.dongpo.tc.service;

/**
 * User: dongpo.li
 * Date: 2020-05-14
 */
public class DepService {

    private SampleService sampleService;

    public void setSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public DepService() {
        System.out.println("开始实例化DepService");
    }

    public void hello() {
        System.out.println("hello world");
    }
}

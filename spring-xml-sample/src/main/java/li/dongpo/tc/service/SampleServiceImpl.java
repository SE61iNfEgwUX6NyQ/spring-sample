package li.dongpo.tc.service;

import java.util.Map;

/**
 * User: dongpo.li
 * Date: 2020-05-14
 */
public class SampleServiceImpl implements SampleService {

    private DepService depService;

    public void setDepService(DepService depService) {
        this.depService = depService;
    }

    @SampleAnnotation("xxx.properties")
    private void annotation(Map<String, String> config){
        System.out.println(config);
    }

    public SampleServiceImpl() {
        System.out.println("开始实例化SampleServiceImpl");
    }

    public void hello() {
        System.out.println("hello world");
    }
}

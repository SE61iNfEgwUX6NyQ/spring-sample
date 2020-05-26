package li.dongpo.tc.service;

import java.util.Map;

/**
 * User: dongpo.li
 * Date: 2020-05-14
 */
public class SampleServiceImpl {

    @SampleAnnotation(group = "app1", file = "xxx.properties")
    public void annotation(Map<String, String> config){
        System.out.println("拉取到配置文件 " + config);
    }
}

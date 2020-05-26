package li.dongpo.tc.service;

import java.lang.annotation.*;

/**
 * dongpo.li
 * 2020/5/20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SampleAnnotation {

    // 表示是哪个应用
    String group();

    // 表示是哪个文件
    String file();
}

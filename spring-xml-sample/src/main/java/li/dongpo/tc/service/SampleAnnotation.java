package li.dongpo.tc.service;

import java.lang.annotation.*;

/**
 * dongpo.li
 * 2020/5/20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SampleAnnotation {
    String value();
}

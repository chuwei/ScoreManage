package cn.geekchu.hgschool.scoremanagement.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Dictionary {
    String id();
    String parentKey() default "";
    String render() default "";
    byte sliceType() default 3;
    boolean multiple() default false;
}

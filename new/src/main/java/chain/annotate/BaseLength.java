package chain.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 基本数据类型长度检测注解(字符串、数组)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseLength {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "Length must be between {min} and {max}";
}

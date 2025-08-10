package chain.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 集合类的长度注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CollectionLength {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "Collection length must be between {min} and {max}";
}

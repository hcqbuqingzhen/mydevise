package strategy.annotate;

import strategy.emnus.EventEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventType {
    EventEnum value() default EventEnum.DEFOUT; // 默认的事件处理类型
}

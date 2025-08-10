package strategy.emnus;

import java.util.function.Predicate;

/**
 * 事件的类型(按照来源、类型等随便什么业务需求进行分类)
 * 不一定要用Predicate这种,随便的方式都可以,只要能判断是否支持即可
 */
public enum EventEnum {
    SZCG(source -> "SZCG".equals(source),"数字城管"),
    YZXX(source -> "YZXX".equals(source),"院长信箱"),
    MSSQ(source -> "MSSQ".equals(source),"民生诉求"),
    SJSB(source -> "SJSB".equals(source),"市局上报"),
    DHSB(source -> "DHSB".equals(source),"督办上报"),
    LDFF(source -> "LDFF".equals(source),"领导吩咐"),
    DEFOUT(source -> "DEFOUT".equals(source),"默认事件")
    ;

    private final Predicate<String> support;

    private final String desc;

    EventEnum(Predicate<String> support, String desc) {
        this.support = support;
        this.desc = desc;
    }

    /**
     * 通过字符串返回对应的事件类型
     */
    public static EventEnum fromString(String source) {
        for (EventEnum eventEnum : values()) {
            if (eventEnum.support.test(source)) {
                return eventEnum;
            }
        }
        return DEFOUT; // 默认事件类型
    }
}

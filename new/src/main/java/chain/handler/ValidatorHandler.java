package chain.handler;

import chain.exception.VaildatorExcption;

/**
 * 用于校验数据
 */
public interface ValidatorHandler {
    /**
     * 校验数据
     *
     * @param value 待校验的数据
     */
    void validate(Object value,ValidatorContext context ) ;
}

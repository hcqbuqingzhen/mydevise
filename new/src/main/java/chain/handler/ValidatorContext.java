package chain.handler;

import chain.exception.VaildatorExcption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidatorContext {
    private final List<String> errors = new ArrayList<>();

    private int index ;

    private Map<String, Object> params;

    public void addError(String error) {
        errors.add(error);
    }

    public boolean isEmpty() {
        return errors.isEmpty();
    }
    /**
     * 判断是否抛出异常
     */
    public void throwExcptionIfNecessary() throws VaildatorExcption {
        if (!isEmpty()) {
            throw new VaildatorExcption(errors.toString());
        }
    }

    public void doNext() {
        index++;
    }
    public int getIndex() {
        return index;
    }

    public void putParam(String key, Object value) {
        params.put(key, value);
    }
}

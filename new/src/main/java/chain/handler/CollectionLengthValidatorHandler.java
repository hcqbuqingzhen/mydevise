package chain.handler;

import chain.exception.VaildatorExcption;

import java.util.Collection;

public class CollectionLengthValidatorHandler implements ValidatorHandler {
    private String fieldName;
    private String message;
    private int min;
    private int max;
    public CollectionLengthValidatorHandler(String fieldName,String message,int min, int max) {
        this.fieldName = fieldName;
        this.message = message;
        this.min = min;
        this.max = max;
    }

    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value instanceof Collection<?> collectionValue && (collectionValue.size() < min || collectionValue.size() > max)) {
            context.addError(fieldName+":collection size must be between \" + min + \" and \" + max");
        }
        context.doNext();
    }
}

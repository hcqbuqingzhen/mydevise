package chain.handler;

import chain.exception.VaildatorExcption;

public class NotNullValidatorHandler implements ValidatorHandler {
    private String fieldName;
    private String message;
    public NotNullValidatorHandler(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value == null) {
            context.addError(fieldName+": cannot be null");
        }
        context.doNext();
    }
}

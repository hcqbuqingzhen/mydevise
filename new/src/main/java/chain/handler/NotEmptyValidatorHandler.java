package chain.handler;

import chain.exception.VaildatorExcption;

public class NotEmptyValidatorHandler implements ValidatorHandler {
    private String fieldName;
    private String message;
    public NotEmptyValidatorHandler(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value == null) {
            context.addError(fieldName+":value cannot be null");
        }
        if (value instanceof String) {
            String strValue = (String) value;
            if (strValue.isEmpty()) {
                context.addError(fieldName+":value cannot be empty");
            }
        }
        context.doNext();
    }
}

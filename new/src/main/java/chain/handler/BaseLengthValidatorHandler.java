package chain.handler;

public class BaseLengthValidatorHandler implements ValidatorHandler {
    private String fieldName;
    private String message;
    private int min;
    private int max;


    public BaseLengthValidatorHandler(String fieldName,String message,int min, int max) {
        this.message = message;
        this.fieldName = fieldName;
        this.min = min;
        this.max = max;
    }

    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value instanceof String ) {
            String strValue = (String) value;
            if (strValue.isEmpty()) {
                context.addError(fieldName+":cannot be empty");
            }else {
                if (strValue.length() < min || strValue.length() > max) {
                    context.addError(fieldName+": length must be between " + min + " and " + max);
                }
            }
        }
        if (value instanceof Object[] arrayValue && (arrayValue.length < min || ((Object[]) value).length > max)) {
            if (arrayValue.length < min || arrayValue.length > max) {
                context.addError(fieldName+": length must be between " + min + " and " + max);
            }
        }
        context.doNext();
    }
}

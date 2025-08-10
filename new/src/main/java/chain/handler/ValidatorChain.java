package chain.handler;

import chain.exception.VaildatorExcption;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {
    private final List<ValidatorHandler> chain = new ArrayList<ValidatorHandler>();

    private final ValidatorContext context = new ValidatorContext();

    public void validate(Object value) throws VaildatorExcption {
        for (int i = 0; i < chain.size(); i++) {
            if (context.getIndex() != i) {
                break;
            }
            chain.get(i).validate(value, context);
        }
        context.throwExcptionIfNecessary();
    }

    public void addHandler(ValidatorHandler handler) {
        chain.add(handler);
    }
}

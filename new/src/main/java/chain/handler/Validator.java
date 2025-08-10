package chain.handler;

import chain.annotate.BaseLength;
import chain.annotate.CollectionLength;
import chain.annotate.NotEmpty;
import chain.annotate.NotNull;

import java.lang.reflect.Field;

/**
 * 用于验证
 */
public class Validator {

    private ValidatorChain builderValidatorChain(Field declaredField) {
        ValidatorChain validatorChain = new ValidatorChain();
        if (declaredField.isAnnotationPresent(NotNull.class)) {
            NotNull annotation = declaredField.getAnnotation(NotNull.class);
            validatorChain.addHandler(new NotNullValidatorHandler(declaredField.getName(),annotation.message()));
        }

        if (declaredField.isAnnotationPresent(NotEmpty.class)) {
            NotEmpty annotation = declaredField.getAnnotation(NotEmpty.class);
            validatorChain.addHandler(new NotEmptyValidatorHandler(declaredField.getName(),annotation.message()));
        }

        if (declaredField.isAnnotationPresent(BaseLength.class)) {
            BaseLength annotation = declaredField.getAnnotation(BaseLength.class);
            int min = annotation.min();
            int max = annotation.max();
            validatorChain.addHandler(new BaseLengthValidatorHandler(declaredField.getName(),annotation.message(),min, max));
        }

        if (declaredField.isAnnotationPresent(CollectionLength.class)) {
            CollectionLength annotation = declaredField.getAnnotation(CollectionLength.class);
            int min = annotation.min();
            int max = annotation.max();
            validatorChain.addHandler(new CollectionLengthValidatorHandler(declaredField.getName(),annotation.message(),min, max));
        }
        return validatorChain;
    }

    public void validate(Object bean) {
        Class<?> aClass = bean.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = null;
            try {
                value = declaredField.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            ValidatorChain validatorChain = builderValidatorChain(declaredField);
            validatorChain.validate(value);
        }

    }

}

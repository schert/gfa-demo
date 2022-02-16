package gov.mef.gfa.common.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {InListValidator.class})
public @interface InList{

    String message() default "{validation.inlist}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    String[] values();
}

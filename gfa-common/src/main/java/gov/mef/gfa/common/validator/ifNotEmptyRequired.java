package gov.mef.gfa.common.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Repeatable(ifNotEmptyRequireds.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ifNotEmptyRequiredValidator.class})
public @interface ifNotEmptyRequired{

    String message() default "{required.notempty}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String isNotEmpty();
    String[] required();
}

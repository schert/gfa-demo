package gov.mef.gfa.common.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

public class InListValidator implements ConstraintValidator<InList, Object> {

	private String[] values;
	private String message;

	@Override
	public void initialize(InList requiredIfChecked) {
		values = requiredIfChecked.values();
		message = requiredIfChecked.message();
	}

	@Override
	public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
		Boolean valid = true;

		if (objectToValidate != null && !Arrays.asList(values).contains(objectToValidate.toString())) {
			HibernateConstraintValidatorContext hibernateConstraintValidatorContext = context.unwrap(HibernateConstraintValidatorContext.class);
			hibernateConstraintValidatorContext.disableDefaultConstraintViolation();
			hibernateConstraintValidatorContext.addMessageParameter("values", String.join(", ", values));
			hibernateConstraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
			return false;
		}

		return valid;
	}
}
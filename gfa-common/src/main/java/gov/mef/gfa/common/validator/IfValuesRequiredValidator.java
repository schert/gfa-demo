package gov.mef.gfa.common.validator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.NestedNullException;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.util.ObjectUtils;

public class IfValuesRequiredValidator implements ConstraintValidator<IfValuesRequired, Object> {

	private String[] values;
	private String message;
	private String[] required;
	private String selected;

	@Override
	public void initialize(IfValuesRequired requiredIfChecked) {
		values = requiredIfChecked.values();
		required = requiredIfChecked.required();
		message = requiredIfChecked.message();
		selected = requiredIfChecked.selected();
	}

	@Override
	public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
		Boolean valid = true;
		Object selectedValue;

		try {

			selectedValue = BeanUtils.getProperty(objectToValidate, selected);

			if (selectedValue != null && Arrays.asList(values).contains(selectedValue.toString())) {
				for (String propName : required) {
					Object requiredValue = BeanUtils.getProperty(objectToValidate, propName);
					valid = requiredValue != null && !ObjectUtils.isEmpty(requiredValue);

					if (!valid) {
						String arrayRequired = String.join(", ", required);
						HibernateConstraintValidatorContext hibernateConstraintValidatorContext = context.unwrap(HibernateConstraintValidatorContext.class);
						hibernateConstraintValidatorContext.disableDefaultConstraintViolation();
						hibernateConstraintValidatorContext.addMessageParameter("selected", selected);
						hibernateConstraintValidatorContext.addMessageParameter("values", String.join(", ", values));
						hibernateConstraintValidatorContext.addMessageParameter("arrayRequired", arrayRequired);
						hibernateConstraintValidatorContext.buildConstraintViolationWithTemplate(message).addPropertyNode(selected).addConstraintViolation();
						break;
					}
				}
			}
		} catch (NestedNullException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			return false;
		}

		return valid;
	}
}
package gov.mef.gfa.common.validator;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.util.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ifNotEmptyRequiredValidator implements ConstraintValidator<ifNotEmptyRequired, Object> {

	private String isNotEmpty;
	private String message;
	private String[] required;

	@Override
	public void initialize(ifNotEmptyRequired requiredIfChecked) {
		isNotEmpty = requiredIfChecked.isNotEmpty();
		required = requiredIfChecked.required();
		message = requiredIfChecked.message();
	}

	@Override
	public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
		Boolean valid = true;

		try {
			String notEmptyValue = BeanUtils.getProperty(objectToValidate, isNotEmpty);
			if (notEmptyValue != null && !notEmptyValue.isEmpty()) {
				for (String propName : required) {
					Object requiredValue = BeanUtils.getProperty(objectToValidate, propName);
					valid = requiredValue != null && !ObjectUtils.isEmpty(requiredValue);

					if (!valid) {
						String arrayRequired = String.join(", ", required);
						HibernateConstraintValidatorContext hibernateConstraintValidatorContext = context.unwrap( HibernateConstraintValidatorContext.class );
						hibernateConstraintValidatorContext.disableDefaultConstraintViolation();
						hibernateConstraintValidatorContext.addMessageParameter("notEmpty", isNotEmpty);
						hibernateConstraintValidatorContext.addMessageParameter("arrayRequired", arrayRequired);
						hibernateConstraintValidatorContext.buildConstraintViolationWithTemplate(message)
						.addPropertyNode(isNotEmpty).addConstraintViolation();
						break;
					}
				}
			}
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			log.info("Errore nel processo di validazione");
			e.printStackTrace();
		}

		return valid;
	}
}
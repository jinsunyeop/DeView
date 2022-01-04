package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import user.dto.UserDto;


public class RegisterRequestValidator implements Validator{
	
	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	

	private Pattern pattern;
	

	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}	

	public boolean supports(Class<?> arg0) {
		return UserDto.class.isAssignableFrom(arg0);
	}

	public void validate(Object target, Errors errors) { //target은 검사 대상 객체 errors는 검사 결과 에러코드를 저장하는 객체
		UserDto user = (UserDto) target;
		if(user.getUserEmail()==null||user.getUserEmail().trim().isEmpty()) {
			errors.rejectValue("userEmail", "required");
		}else{
			Matcher matcher = pattern.matcher(user.getUserEmail());
			if(!matcher.matches()) {
				errors.rejectValue("userEmail", "notEmailPattern");
			}
		
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPassword","required");
		ValidationUtils.rejectIfEmpty(errors, "userGender","required");

	}
}

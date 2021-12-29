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
	
	private static final String ageRegExp="^[0-9]+$";

	private Pattern pattern;
	
	private Pattern pattern2;


	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}	

	public boolean supports(Class<?> arg0) {
		return UserDto.class.isAssignableFrom(arg0);
	}

	public void validate(Object target, Errors errors) { //target은 검사 대상 객체 errors는 검사 결과 에러코드를 저장하는 객체
		UserDto user = (UserDto) target;
		if(user.getEmail()==null||user.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}else{
			Matcher matcher = pattern.matcher(user.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "notEmailPattern");
			}
		
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password","required");
		ValidationUtils.rejectIfEmpty(errors, "nickname","required");
		ValidationUtils.rejectIfEmpty(errors, "gender","required");

	}
}

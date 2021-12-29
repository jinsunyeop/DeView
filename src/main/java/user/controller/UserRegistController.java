package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import user.dto.UserDto;
import user.service.UserService;
import validator.RegisterRequestValidator;


@Controller
public class UserRegistController {
	
	@Autowired
	private UserService userService;
	
	public void setMemberService(UserService userService) {
		this.userService = userService;
	}

	
	@RequestMapping(value="/user/regist")
	public String regist(Model model){
		model.addAttribute("user",new UserDto()); //커멘드 객체
		return "user/regist";
	}
	
	@RequestMapping(value="/user/success",method=RequestMethod.GET)
	public String regist(){
		return "redirect:/user/regist";
	}
	
	
	@RequestMapping(value="/user/success",method=RequestMethod.POST)
	public String regist2(@ModelAttribute("user")UserDto user,Errors errors,
			@RequestParam(value="confirmPw", required=true) String confirmPw) {
		
		new RegisterRequestValidator().validate(user, errors);
		if(!user.getPassword().isEmpty()) {
			if(!user.getPassword().equals(confirmPw)) {
				errors.rejectValue("password", "NotMatchPassword");
			}
		}	
		if(errors.hasErrors()) {
			return "user/regist";
		}
//		위에는 회원 가입 형식 검증
		try {
			userService.insertUser(user);
			return "user/success";
		}catch(DuplicateKeyException e) {
			errors.rejectValue("email", "AlreadyRegist");
			return "user/regist";
		}				
	}
	
	
	
}
package user.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import exception.DoNotAgreeException;
import exception.MemberNotMatchingException;
import exception.PwNotMatchingException;
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
			return "redirect:/user/login";
		}catch(DuplicateKeyException e) {
			errors.rejectValue("email", "AlreadyRegist");
			return "user/regist";
		}				
	}
	
	//비밀번호 변경 구현
	@RequestMapping(value="/user/changePw",method=RequestMethod.GET)
	public ModelAndView change(Model model){
		ModelAndView mv = new ModelAndView();
		model.addAttribute("changePw", new changePwCommand());
		mv.addObject("changePw");
		mv.setViewName("/user/changePw");
		return mv;
	}
	
	@RequestMapping(value="/user/changePw",method=RequestMethod.POST)
	public String change(@ModelAttribute("changePw") @Valid changePwCommand edit,BindingResult bindingResult,
						HttpSession session,Errors errors){
		if(bindingResult.hasErrors()) {
			return "/user/changePw";
		}
		UserDto user = (UserDto)session.getAttribute("user");
		try {
			userService.changePw(user.getEmail(), edit.getCurrentPassword(), edit.getNewPassword());
			return "/profile/profile";
		}catch(PwNotMatchingException e) {
			errors.reject("NotMatchPassword");
			return "/user/changePw";
		}catch(MemberNotMatchingException e) {
			errors.reject("MemberNotMatching");
			return "/user/changePw";
		}
	}
	
	//회원 탈퇴
	@RequestMapping(value="/user/delete",method=RequestMethod.GET)
	public String delete(Model model,HttpSession session){
		model.addAttribute("delete", new DeleteCommand());
		
		
		return "/user/deleteUser";
	}
	

	
	
	@RequestMapping(value="/user/delete",method=RequestMethod.POST)
	public String delete(@ModelAttribute("delete") @Valid DeleteCommand deleteCommand,BindingResult bindingResult,Errors errors){
		if(bindingResult.hasErrors()) {
			return "/user/deleteUser";
		}
		DeleteCommand confirm= deleteCommand;
		System.out.println(confirm.toString());
		try {
			userService.delete(confirm.getEmail(), confirm.isAgree(),confirm.getPassword());
			return "/profile/profile";
		}catch(PwNotMatchingException e) {
			errors.reject("NotMatchPassword");
			return "/user/deleteUser";
		}catch(MemberNotMatchingException e) {
			errors.reject("MemberNotMatching");
			return "/user/deleteUser";
		}catch( DoNotAgreeException e) {
			errors.reject("DoNotAgree");
			return "/user/deleteUser";
		}
	}
	
	
	
	
	
}
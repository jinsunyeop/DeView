package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import user.dto.DeleteCommand;
import user.dto.UserDto;
import user.dto.changePwCommand;
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
		model.addAttribute("user",new UserDto()); 
		return "user/regist";
	}
	
	@RequestMapping(value="/check.do" ,method = RequestMethod.POST)
	public ResponseEntity check(@RequestParam("id") String id,HttpServletRequest req, HttpServletResponse resp) throws Exception{
		ResponseEntity resEntity = null;
		String result = userService.checkEmail(id);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	
	
	
	@RequestMapping(value="/user/success",method=RequestMethod.GET)
	public String regist(){
		return "redirect:/user/regist";
	}
	
	
	@RequestMapping(value="/user/success",method=RequestMethod.POST)
	public String regist2(@ModelAttribute("user")UserDto user,Errors errors,
			@RequestParam(value="confirmPw", required=true) String confirmPw) {
		
		new RegisterRequestValidator().validate(user, errors);
		if(!user.getUserPassword().isEmpty()) {
			if(!user.getUserPassword().equals(confirmPw)) {
				errors.rejectValue("userPassword", "NotMatchPassword");
			}
		}	
		if(errors.hasErrors()) {
			return "user/regist";
		}
		try {
			userService.insertUser(user);
			return "redirect:/user/login";
		}catch(DuplicateKeyException e) {
			errors.rejectValue("userEmail", "AlreadyRegist");
			return "user/regist";
		}				
	}
	
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
			userService.changePw(user.getUserEmail(), edit.getCurrentPassword(), edit.getNewPassword());
			return "/profile/profile";
		}catch(PwNotMatchingException e) {
			errors.reject("NotMatchPassword");
			return "/user/changePw";
		}catch(MemberNotMatchingException e) {
			errors.reject("MemberNotMatching");
			return "/user/changePw";
		}
	}
	
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
			return "redirect:/main";
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
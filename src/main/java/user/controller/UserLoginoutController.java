package user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exception.MemberNotMatchingException;
import exception.PwNotMatchingException;
import user.dto.UserDto;
import user.service.UserService;

@Controller
public class UserLoginoutController {
	
	@Autowired
	private UserService userService;

	public void setLoginService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value={"/user/login","/login"},method=RequestMethod.GET)
	public String login(Model model,@CookieValue(value="remember",required=false)Cookie cookie,HttpSession session) {

		Object user = session.getAttribute("user");
		if(user !=null) {
			return "/main";
		}
		
		LoginCommand loginCommand = new LoginCommand();
		//쿠키 생성
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		model.addAttribute("login",loginCommand);
		
		return "/user/login";
	}
	
		
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String submit(Model model,@ModelAttribute("login") @Valid LoginCommand loginCommand,BindingResult bindingResult,
						HttpSession session,HttpServletResponse resp) {
		if(bindingResult.hasErrors()) {
			return "/user/login";
		}
		try {
			UserDto user = userService.login(loginCommand.getEmail(),
												loginCommand.getPassword());
			session.setAttribute("user", user);
			
			Cookie rememberCookie = new Cookie("remember",loginCommand.getEmail());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*23*30);
			}else {
				rememberCookie.setMaxAge(0);
			}
			resp.addCookie(rememberCookie);
			
			return "redirect:/main";
		}catch(MemberNotMatchingException e) {
			model.addAttribute("msg1","없는 회원 정보입니다.");
			return "/user/login";
		}catch(PwNotMatchingException e) {
			model.addAttribute("msg2","계정과 맞지 않는 비밀번호 입니다.");
			return "/user/login";
			
		}
	}
	
	@RequestMapping(value="/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

}

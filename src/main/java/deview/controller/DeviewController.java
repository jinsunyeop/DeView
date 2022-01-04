package deview.controller;

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

import deview.dto.DeviewDto;
import deview.service.DeviewService;
import user.dto.ProfileDto;
import user.dto.UserDto;
import user.service.ProfileService;
import validator.RegisterRequestValidator;

@Controller
public class DeviewController {
	
	@Autowired
	DeviewService deviewService;
	
	@Autowired
	ProfileService profileService;
	
	@RequestMapping(value="/deview/start",method=RequestMethod.GET)
	public String profile(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		ProfileDto profile = profileService.selectProfile(user.getUserId());
		
		if(deviewService.selectDeview(user.getUserId())!=null){
			return "redirect:/profile/profile";
		}else {
			model.addAttribute("user",user);
			model.addAttribute("profile",profile);
			model.addAttribute("command",new DeviewDto());

			return "/deview/start";
		}


	}
	
	@RequestMapping(value="/deview/start",method=RequestMethod.POST)
	public String regist2(@ModelAttribute("command") @Valid DeviewDto deview,BindingResult bindingResult,Errors error) {
		
		if(bindingResult.hasErrors()) {
			return"/deview/start";
		}
		
		try {
			deviewService.insertDeview(deview);
			return "redirect:/profile/profile";
		}catch(NumberFormatException e) {
			error.rejectValue("devPrice", "required");
			return "/deview/start";
		}
		
	}

}

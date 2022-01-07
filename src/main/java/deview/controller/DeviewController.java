package deview.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import deview.dto.DeviewDto;
import deview.service.DeviewService;
import user.dto.ProfileDto;
import user.dto.UserDto;
import user.service.ProfileService;
import user.service.UserService;
import validator.RegisterRequestValidator;

@Controller
public class DeviewController {
	
	@Autowired
	DeviewService deviewService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserService userService;
	
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
	
	@RequestMapping(value="/deview/read/{userId}",method=RequestMethod.GET)
	public String read(Model model,@PathVariable int userId) {
		
		DeviewDto deview=deviewService.selectDeview(userId);
		ProfileDto profile = profileService.selectProfile(userId);
		UserDto user = userService.selectId(userId);
		model.addAttribute("user",user);
		model.addAttribute("deview",deview);
		model.addAttribute("profile",profile);

		
		
		return "/deview/read";
	}
	
	@RequestMapping(value="/deview/edit",method=RequestMethod.GET)
	public String edit(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		ProfileDto profile = profileService.selectProfile(user.getUserId());
		DeviewDto deview = deviewService.selectDeview(user.getUserId());
		
			model.addAttribute("user",user);
			model.addAttribute("profile",profile);
			model.addAttribute("command",deview);

			return "/deview/edit";
	}
	
	
	@RequestMapping(value="/deview/edit",method=RequestMethod.POST)
	public String edit(@ModelAttribute("command") @Valid DeviewDto deview,BindingResult bindingResult,Errors error) {
		
		if(bindingResult.hasErrors()) {
			return"/deview/edit";
		}
		
		try {
			deviewService.updateDeview(deview);
			return "redirect:/profile/profile";
		}catch(NumberFormatException e) {
			error.rejectValue("devPrice", "required");
			return "/deview/edit";
		}
	}
	
	@RequestMapping(value="/deview/delete",method=RequestMethod.GET)
	public String delete(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		DeviewDto deviewDto = deviewService.selectDeview(user.getUserId());
			model.addAttribute("deview",deviewDto);

			return "/deview/delete";
	}
	
	@RequestMapping(value="/deview/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("devId") int devId) {
		deviewService.deleteDeview(devId);

			return "redirect:/profile/profile";
	}	

}

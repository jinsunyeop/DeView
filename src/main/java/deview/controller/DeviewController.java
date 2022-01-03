package deview.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deview.dto.DeviewDto;
import deview.service.DeviewService;
import user.dto.ProfileDto;
import user.dto.UserDto;
import user.service.ProfileService;

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
		
		model.addAttribute("user",user);
		model.addAttribute("profile",profile);
		model.addAttribute("command",new DeviewDto());

		return "/deview/start";

	}
	

}

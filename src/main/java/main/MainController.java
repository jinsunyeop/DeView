package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import deview.dto.DeviewDto;
import deview.service.DeviewService;
import user.dto.ProfileDto;
import user.service.ProfileService;

@Controller
public class MainController {

	@Autowired
	DeviewService deviewService;
	
	@Autowired
	ProfileService profileService;
	
	
	@RequestMapping(value= {"/main/main"},method=RequestMethod.GET)
	public String main(Model model) {
		
		List<DeviewDto> deviewList =deviewService.listDeview();
		List<ProfileDto> profileList=profileService.joinDeview(); //deview 테이블과 user_id inner조인
		for(int i =0;i<deviewList.size();i++) {
			System.out.println(deviewList.get(i));
		}
		model.addAttribute("deviewList",deviewList);
		model.addAttribute("profileList",profileList);
		
		return "/main/main";
	}
	
	
	
}

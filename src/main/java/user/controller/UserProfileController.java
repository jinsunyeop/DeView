package user.controller;

import java.io.File;
import java.text.Normalizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import user.dto.ProfileDto;
import user.dto.UserDto;
import user.service.ProfileService;

@Controller
public class UserProfileController {

	@Autowired
	private ProfileService profileService;

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@RequestMapping(value="/user/profile/profile",method=RequestMethod.GET)
	public String profile(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		//만약 세션을 겟해서 그 세션을 가진 사람이 프로필에 접근을 한다면
		if(user!=null) {
		model.addAttribute("profile",profileService.selectProfile(user.getUserId()));
		return "/user/profile/profile";
		}
		//그게 아니라면 로그인을 해라
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/user/profile/insert",method=RequestMethod.GET)
	public String edit(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		//만약 세션을 겟해서 그 세션을 가진 사람이 프로필에 접근을 한다면
		if(user!=null) {
			//근데 그사람이 프로필이 있다면 수정하는 폼으로 가라
			if(profileService.selectProfile(user.getUserId())!=null) {
				return "redirect:/user/profile/profile";
			}else {
				System.out.println("여기");
				model.addAttribute("profile",new ProfileDto());
				return "/user/profile/insert";
			}
		}
		//그게 아니라면 로그인을 해라
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/user/profile/insert",method=RequestMethod.POST)
	public String edit(@ModelAttribute("profile") @Valid ProfileDto profile,
			BindingResult bindingResult,@RequestParam(value="img",required=false)MultipartFile img,
			Model model,HttpServletRequest req) {
		
		String fileName = img.getOriginalFilename();
		System.out.println(fileName);
		fileName = Normalizer.normalize(fileName, Normalizer.Form.NFC); //Mac에서 만든 파일을 윈도우에서 사용할땐 자모가 분리될 수 있는 현상
		String filePath=req.getSession().getServletContext().getRealPath("/")+"resources/image";
				
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return"/user/profile/insert";
		}
			
		if(!fileName.isEmpty()) {
			try {
				File p =  new File(filePath+"//"+fileName);
				img.transferTo(p);
				profile.setImgName(fileName);
				profileService.insertProfile(profile);
			}catch(Exception e) {
				return "/user/profile/profile";
			}
		}else {
			profileService.insertProfile(profile);
			return "/user/profile/profile";
		}
		
		return "redirect:/user/profile/profile";
	}

	
	
	
	
	
}

package user.controller;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

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

import chat.service.ChatService;
import deview.service.DeviewService;
import matching.service.MatchingService;
import user.dto.ProfileDto;
import user.dto.UserDto;
import user.service.ProfileService;
import user.service.UserService;

@Controller
public class UserProfileController {
	
	@Autowired
	private ChatService chatService;

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private DeviewService deviewService;

	@Autowired
	private MatchingService matchingService;

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@RequestMapping(value="/profile/profile",method=RequestMethod.GET)
	public String profile(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		List<ProfileDto> profileList1 =  new ArrayList<ProfileDto>();
		List<ProfileDto> profileList2 =  new ArrayList<ProfileDto>();
		List<ProfileDto> completeList =  new ArrayList<ProfileDto>();

		int uId=user.getUserId();
		model.addAttribute("profile",profileService.selectProfile(uId));
		model.addAttribute("deview",deviewService.selectDeview(uId));
			
		
		for(int i=0; i<matchingService.selectApply(uId).size(); i++) {
		ProfileDto profile= profileService.selectProfile(Integer.parseInt(matchingService.selectApply(uId).get(i).getMatchingRequest()));
		profileList1.add(profile);
		}
		model.addAttribute("profileList1",profileList1);
		
		for(int i=0; i<matchingService.selectRequest(uId).size(); i++) {
			ProfileDto profile= profileService.selectProfile(Integer.parseInt(matchingService.selectRequest(uId).get(i).getMatchingApply()));
			profileList2.add(profile);
		}
		model.addAttribute("profileList2",profileList2);

		for(int i=0; i<matchingService.completeMatching(uId).size(); i++) {
			if(Integer.parseInt(matchingService.completeMatching(uId).get(i).getMatchingRequest())==uId){
				ProfileDto profile= profileService.selectProfile(Integer.parseInt(matchingService.completeMatching(uId).get(i).getMatchingApply()));
				completeList.add(profile);
			}else {
				ProfileDto profile= profileService.selectProfile(Integer.parseInt(matchingService.completeMatching(uId).get(i).getMatchingRequest()));
				completeList.add(profile);
			}
		}
		model.addAttribute("completeList",completeList);
		
			
		
		return "/profile/profile";
	}
		
	@RequestMapping(value="/profile/insert",method=RequestMethod.GET)
	public String insert(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		if(profileService.selectProfile(user.getUserId())!=null) {
			return "redirect:/profile/edit";
		}else {
			model.addAttribute("profile",new ProfileDto());
			return "/profile/insert";
		}
	}
	
	@RequestMapping(value="/profile/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("profile") @Valid ProfileDto profile,
			BindingResult bindingResult,@RequestParam(value="img",required=false)MultipartFile img,
			Model model,HttpServletRequest req) {
		String path = "/resources//image";
		
		String fileName = img.getOriginalFilename();
		System.out.println(fileName);
		fileName = Normalizer.normalize(fileName, Normalizer.Form.NFC); //Mac에서 만든 파일을 윈도우에서 사용할땐 자모가 분리될 수 있는 현상
		String filePath=req.getServletContext().getRealPath("/")+path;

		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return"/profile/insert";
		}
			
		if(!fileName.isEmpty()) {
			try {
				File p =  new File(filePath+"/"+fileName);
				img.transferTo(p);
				profile.setProfileImg(fileName);
				profileService.insertProfile(profile);
			}catch(RuntimeException e) {
				return "/profile/profile";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			profileService.insertProfile(profile);
			return "/profile/profile";
		}
		
		return "redirect:/profile/profile";
	}
	
	@RequestMapping(value="/profile/edit",method=RequestMethod.GET)
	public String edit(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");

		model.addAttribute("profile",profileService.selectProfile(user.getUserId()));
		model.addAttribute("newProfile",new ProfileDto());
		return "/profile/edit";
	}
	

	@RequestMapping(value="/profile/edit",method=RequestMethod.POST)
	public String edit(@ModelAttribute("newProfile") @Valid ProfileDto profile,
			BindingResult bindingResult,@RequestParam(value="img",required=false)MultipartFile img,
			Model model,HttpServletRequest req) {
		String oldImgName =  req.getParameter("oldImgName");
		
		String path = "/resources//image";
		
		String fileName = img.getOriginalFilename();
		
		fileName = Normalizer.normalize(fileName, Normalizer.Form.NFC); 
		String filePath=req.getServletContext().getRealPath("/")+path;
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return"/profile/edit";
		}
		
		if(fileName != oldImgName) {
			try {
				File p =  new File(filePath+"/"+fileName);
				img.transferTo(p);
				new File(filePath+"/"+ oldImgName).delete(); 
				profile.setProfileImg(fileName);
				profileService.updateProfile(profile);
			}catch(Exception e) {
				return "/profile/profile";
			}
		}else{
			profile.setProfileImg(oldImgName);
			profileService.updateProfile(profile);
			return "/profile/profile";
		}

		return "redirect:/profile/profile";
	}
	
	@RequestMapping(value="/matching/delete",method=RequestMethod.GET)
	public String matchDelete(@RequestParam(value="request", required=false)String request,HttpSession session) { 	
		UserDto user = (UserDto)session.getAttribute("user");
		int applyId = user.getUserId();
		int requestId = Integer.parseInt(request);
		matchingService.matchingCancel(requestId, applyId);


		return "redirect:/profile/profile";
	}
	
	@RequestMapping(value="/matching/update",method=RequestMethod.GET)
	public String matchUpdate(@RequestParam(value="request", required=false)String request,HttpSession session) { 	
		UserDto user = (UserDto)session.getAttribute("user");
		int applyId = user.getUserId();
		int requestId = Integer.parseInt(request);
		matchingService.updateMatching(requestId, applyId);

		return "redirect:/profile/profile";
	}
	
	
	
}

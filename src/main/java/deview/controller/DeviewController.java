package deview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import net.sf.json.JSONObject;

import deview.dto.DeviewDto;
import deview.service.DeviewService;
import matching.dto.MatchingDto;
import matching.service.MatchingService;
import net.sf.json.JSONObject;
import user.dto.ProfileDto;
import user.dto.UserDto;
import user.service.ProfileService;
import user.service.UserService;

@Controller
public class DeviewController {
	
	@Autowired
	DeviewService deviewService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MatchingService matchingService;
	
	@RequestMapping(value="/keywordSearch.do",method=RequestMethod.GET,produces="application/text;charset=utf8")
	public @ResponseBody String keywordSearch(@RequestParam("keyword") String keyword,HttpServletRequest req,HttpServletResponse resp) {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		if(keyword==null || keyword.equals("")) return null;
		
		keyword=keyword.toUpperCase();
		List keywordList = deviewService.deviewSearch(keyword);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyword", keywordList);
		String jsonInfo = jsonObject.toString();
		return jsonInfo;
	}
	
	
	
	
	@RequestMapping(value="/deview/start",method=RequestMethod.GET)
	public String profile(Model model,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		ProfileDto profile = profileService.selectProfile(user.getUserId());
		
		if(deviewService.selectDeview(user.getUserId())!=null){ //프로필과 데뷰 서비스 1 대 1
			return "redirect:/profile/profile";
		}
		if(profileService.countProfile(user.getUserId())==0) {
			return "redirect:/profile/insert";
		}
		else {
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
		
			deviewService.insertDeview(deview);
			return "redirect:/profile/profile";

		
	}
	
	@RequestMapping(value="/deview/read/{userId}",method=RequestMethod.GET)
	public String read(Model model,@PathVariable int userId,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		
		DeviewDto deview=deviewService.selectDeview(userId);
		ProfileDto profile = profileService.selectProfile(userId);
		UserDto deviewUser = userService.selectId(userId);
		MatchingDto matching = matchingService.selectMatching(user.getUserId(), userId);
		int myProfile = profileService.countProfile(user.getUserId());

		model.addAttribute("myProfile",myProfile);
		model.addAttribute("myUserId",user.getUserId());
		model.addAttribute("user",deviewUser);
		model.addAttribute("deview",deview);
		model.addAttribute("profile",profile);
		model.addAttribute("matching",new MatchingDto()); //커맨드
		try {
			model.addAttribute("matchingStatus",matching.isMatchingStatus());

		}catch(NullPointerException e) {
			model.addAttribute("matchingStatus",null);
		}

		return "/deview/read";
	}
	
	@RequestMapping(value="/deview/read/{userId}",method=RequestMethod.POST)
	public String delete(@ModelAttribute("matching") MatchingDto matching) {

		int request = Integer.parseInt(matching.getMatchingRequest());
		int apply = Integer.parseInt(matching.getMatchingApply());
		matchingService.requestMatching(request,apply);
		
		return "redirect:/deview/read/{userId}";
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

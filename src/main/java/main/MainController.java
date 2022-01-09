package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	public 	Map<String,Integer> paging(String page,int size){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int deviewCount = size; //deview 전체 갯수
		int pageDeview = 9;
		int pages ;
		if(deviewCount%pageDeview==0) {
			pages = deviewCount/pageDeview;
		}else {
			pages = deviewCount/pageDeview +1;
		}
		if(page == null) { 
			page ="1";
		}
		int currentPage = Integer.parseInt(page);
		int start = (currentPage-1) * pageDeview; 
		
		map.put("pages", pages);
		map.put("pageDeview", pageDeview);
		map.put("start", start);
		return map;
		}
	
	
	
	@RequestMapping(value= {"/main/main"},method=RequestMethod.GET)
	public String main(Model model,HttpServletRequest req) {
		
		String page = req.getParameter("page"); //페이지 파라미터
		int size = deviewService.listDeview().size();
		Map<String,Integer> map = paging(page,size);
		
		
		List<DeviewDto> deviewList =deviewService.pagingDeviewList(map.get("start"),map.get("pageDeview"));
		List<ProfileDto> profileList=profileService.joinDeview(); //deview 테이블과 user_id inner조인

		model.addAttribute("allPage",map.get("pages"));
		model.addAttribute("deviewList",deviewList);
		model.addAttribute("profileList",profileList);
		
		return "/main/main";
	}
	
	@RequestMapping(value= {"/list/list"},method=RequestMethod.GET)
	public String list(Model model,HttpServletRequest req) {
		int lang = Integer.parseInt(req.getParameter("lang"));
		String language =null;
		switch(lang) {
		case 1: 
			language="C";
			break;
		case 2:
			language="C#";
			break;
		case 3:
			language="C++";
			break;		
		case 4:
			language="JAVA";
			break;
		case 5:
			language="PYTHON";
			break;
		case 6:
			language="KOTLIN";
			break;
		}
		
		
		List<DeviewDto> deviewList= deviewService.deviewBigcate(language);
		List<ProfileDto> profileList=profileService.joinDeview(); //deview 테이블과 user_id inner조인
		System.out.println(lang);
		
		model.addAttribute("deviewList",deviewList);
		model.addAttribute("profileList",profileList);
		
		return "/list/list";
	}

	
	
	
	
	
}

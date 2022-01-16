package chat.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chat.dto.ChatDto;
import chat.service.ChatService;
import user.dto.ProfileDto;
import user.dto.UserDto;
import user.service.ProfileService;


@Controller
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	ProfileService profileService;
	
	@RequestMapping(value="/matching/chatToId/{Id}",method=RequestMethod.GET)
	public String chatting1(Model model,@PathVariable String Id,HttpSession session) {
		int toId = Integer.parseInt(Id);
		UserDto user = (UserDto)session.getAttribute("user");
		int fromId = user.getUserId();
		ProfileDto profile1 = profileService.selectProfile(fromId);
		ProfileDto profile2 = profileService.selectProfile(toId);

		
		List<ChatDto> chatting =  chatService.chatById(fromId, toId);
		if(chatting.isEmpty()) {
			return "redirect:/profile/profile";
		}
		int chatId = chatting.get(0).getChatId();

		model.addAttribute("profile1",profile1);
		model.addAttribute("profile2",profile2);
		model.addAttribute("chatting",chatting);
		model.addAttribute("chatId",chatId);
		model.addAttribute("toId",toId);

		return "/matching/chat";
	}
	
	@RequestMapping(value="/matching/chatToId",method=RequestMethod.POST)
	public String chatting1(HttpServletRequest req,HttpSession session)  {
		ChatDto chatDto = new ChatDto();

		try {
		chatDto.setChatId( Integer.parseInt(URLDecoder.decode(req.getParameter("chatId"),"UTF-8")));
		chatDto.setFromId(Integer.parseInt(URLDecoder.decode(req.getParameter("fromId"),"UTF-8")));
		chatDto.setToId( Integer.parseInt(URLDecoder.decode(req.getParameter("toId"),"UTF-8")));
		chatDto.setChatContent(URLDecoder.decode(req.getParameter("chatContent"),"UTF-8"));
		chatService.insertChat(chatDto);
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:/matching/chatToId/"+req.getParameter("toId");

	}
	
	@RequestMapping(value="/matching/chatFromId/{Id}",method=RequestMethod.GET)
	public String chatting(Model model,@PathVariable String Id,HttpSession session) {
		int fromId = Integer.parseInt(Id); //
		UserDto user = (UserDto)session.getAttribute("user");
		int toId = user.getUserId();
		ProfileDto profile1 = profileService.selectProfile(fromId);  //사스케
		ProfileDto profile2 = profileService.selectProfile(toId);   //나 자신

		List<ChatDto> chatting =  chatService.chatById(fromId, toId);
		if(chatting.isEmpty()) {
			return "redirect:/profile/profile";
		}
		
		int chatId = chatting.get(0).getChatId();

		model.addAttribute("profile1",profile1);
		model.addAttribute("profile2",profile2);
		model.addAttribute("chatting",chatting);
		model.addAttribute("chatId",chatId);
		model.addAttribute("fromId",fromId);

		return "/matching/chat2";
	}

	@RequestMapping(value="/matching/chatFromId",method=RequestMethod.POST)
	public String chatting(HttpServletRequest req,HttpSession session)  {
		ChatDto chatDto = new ChatDto();

		try {
		chatDto.setChatId( Integer.parseInt(URLDecoder.decode(req.getParameter("chatId"),"UTF-8")));
		chatDto.setFromId(Integer.parseInt(URLDecoder.decode(req.getParameter("fromId"),"UTF-8")));
		chatDto.setToId( Integer.parseInt(URLDecoder.decode(req.getParameter("toId"),"UTF-8")));
		chatDto.setChatContent(URLDecoder.decode(req.getParameter("chatContent"),"UTF-8"));
		chatService.insertChat(chatDto);
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:/matching/chatFromId/"+req.getParameter("toId");

	}

}

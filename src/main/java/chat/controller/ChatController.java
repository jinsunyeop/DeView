package chat.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@Autowired
	ChatDto chatdto;
	
	@RequestMapping(value="/matching/chat/{Id}",method=RequestMethod.GET)
	public String chatting(Model model,@PathVariable String Id,HttpSession session) {
		UserDto user = (UserDto)session.getAttribute("user");
		int fromId = Integer.parseInt(Id);
		int toId = user.getUserId();
		
		ProfileDto yourProfile = profileService.selectProfile(fromId);
		ProfileDto myProfile = profileService.selectProfile(toId);
		List<ChatDto> chatting =  chatService.chatById(fromId, toId);
		
		int chatId = chatting.get(0).getChatId();
		
		model.addAttribute("yourProfile",yourProfile);
		model.addAttribute("myProfile",myProfile);
		model.addAttribute("chatting",chatting);
		model.addAttribute("fromId",fromId);
		model.addAttribute("chatId",chatId);

		return "/matching/chat";
	}
	
	@RequestMapping(value="/matching/chat",method=RequestMethod.POST)
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
		return "redirect:/matching/chat/"+req.getParameter("fromId");

	}
	
	
	@RequestMapping(value="/matching/sendFile",method=RequestMethod.POST)
	public String sendFile(HttpServletRequest req,HttpSession session,@RequestParam(value="file")MultipartFile file,Model model)  {
		String fileName =  file.getOriginalFilename();
		System.out.println(fileName);
		fileName = Normalizer.normalize(fileName, Normalizer.Form.NFC); 
		int fromId = Integer.parseInt(req.getParameter("fromId"));
		int toId = Integer.parseInt(req.getParameter("toId"));
		int chatId = Integer.parseInt(req.getParameter("chatId"));

		String path = "/resources//chatFile";
		String filePath=req.getServletContext().getRealPath("/")+path;
		try {
			
			File p =  new File(filePath+"/"+fileName);
			file.transferTo(p);
			chatdto.setChatId(chatId);
			chatdto.setFromId(fromId);
			chatdto.setToId(toId);
			chatdto.setChatFile(fileName);
			chatService.insertFile(chatdto);
			
		}catch(Exception e) {
			model.addAttribute("msg","업로드 실패하였습니다");
			return "/matching/chat"+req.getParameter("fromId");
		}
		
		return "redirect:/matching/chat/"+req.getParameter("fromId");
	}
	
	
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public void download(HttpServletRequest req,HttpServletResponse resp) throws Exception {
	        String fileName = req.getParameter("chatFile");
	        String path = "/resources//chatFile";
			String filePath=req.getServletContext().getRealPath("/")+path;
	        try {
	        	resp.setContentType("text/html;charset=utf-8");
	        	File file = new File(filePath+"//"+fileName);
	        	if(!file.exists()) {
	        		System.out.println("파일없음");
	        	}else {
	        		InputStream is = null;
	        		OutputStream os = null;
	        		try {
	        			 is = new FileInputStream(file);
	        		}catch(Exception e) {
	        			
	        		}
	        		String browser = req.getHeader("User-Agent"); 
	                //파일 인코딩 
	                if (browser.contains("MSIE") || browser.contains("Trident")
	                        || browser.contains("Chrome")) {
	                	fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+",
	                            "%20");
	                } else {
	                	fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	                }
	                resp.reset();
	                resp.setContentType("application/octet-stream");
	                resp.setHeader("content-Disposition", "attachment; filename=\""+fileName+"\"");
	                os = resp.getOutputStream();
	                byte b[] = new byte[(int)file.length()];
	                int leng = 0;
	                while((leng=is.read(b))>0) {
	                	os.write(b,0,leng);
	                	
	                }
	                is.close();
	                os.close();
	            } 
	        		
	        	
	        	
	        	
	        }catch(Exception e){
	        	e.printStackTrace();
	        	
	        }
	        
	
		}

	
	
	

}

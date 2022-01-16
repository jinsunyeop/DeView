package chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chat.dto.ChatDto;
import chat.repository.ChatDao;

@Service
public class ChatService {
	@Autowired
	ChatDao chatDao;

	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

	public void createChat(int request,int apply) {
		chatDao.createChat(request, apply);
	}
	
	public void insertChat(ChatDto chatDto) {
		chatDao.insertChat(chatDto);
	}
	

	public List<ChatDto> chatById(int fromId,int toId){
		
		return chatDao.chatById(fromId, toId);
	}
	
//	public String chatById(int fromId, int toId){
//		StringBuffer result = new StringBuffer("");
//		List<ChatDto> chatList = chatDao.chatById(fromId, toId);
//		for(int i = 0; i < chatList.size();i++) {
//			result.append("[{\"value\":\""+chatList.get(i).getFromId()+"\"},");
//			result.append("[{\"value\":\""+chatList.get(i).getToId()+"\"},");
//			result.append("[{\"value\":\""+chatList.get(i).getChatContent()+"\"}]");
//			if(i != chatList.size()-1) result.append(",");
//			
//		}
//		result.append("],\"last\":\""+chatList.get(chatList.size()-1).getChatId()+"\"}");
//		
//		return result.toString();
//	}
	
}

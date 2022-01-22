package chat.service;

import java.util.ArrayList;
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

	
	public void insertChat(ChatDto chatDto) {
		chatDao.insertChat(chatDto);
	}
	
	public void insertFile(ChatDto chatDto) {
		chatDao.insertFile(chatDto);
	}
	
	
	
	
	public List<ChatDto> chatById(int fromId,int toId){
		List<ChatDto> create =  new ArrayList<ChatDto>();
		if (chatDao.chatById(fromId, toId).size()==0) {
			int chat_id = chatDao.createChat(fromId, toId);
			ChatDto chat = chatDao.createChatDate(chat_id);
			create.add(chat);
			return create;
		}
		
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

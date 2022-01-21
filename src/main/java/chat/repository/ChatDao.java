package chat.repository;

import java.util.Date;
import java.util.List;

import chat.dto.ChatDto;


public interface ChatDao {
	
	public abstract int createChat(int fromId,int toId);
	
	public abstract ChatDto createChatDate(int chatId);
	
	public abstract List<ChatDto> chatById(int fromId,int toId);

	public abstract void insertChat(ChatDto chatDto);
	
	public abstract void insertFile(ChatDto chatDto);

}

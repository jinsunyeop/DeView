package chat.repository;

import java.util.List;

import chat.dto.ChatDto;


public interface ChatDao {
	
	public abstract void createChat(int request,int apply);
	
	public abstract List<ChatDto> chatById(int fromId,int toId);

	public abstract void insertChat(ChatDto chatDto);

}

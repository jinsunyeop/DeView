package chat.dto;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component(value="chatDto")
@Alias(value="chatDto")
public class ChatDto {
	private int chatId;
	private int fromId;
	private int toId;
	private String chatContent;
	private Timestamp chatDate;
	private String chatFile;
	private int chatCreate;
	
	
	public ChatDto() {
		super();
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public Timestamp getChatDate() {
		return chatDate;
	}
	public void setChatDate(Timestamp chatDate) {
		this.chatDate = chatDate;
	}
	public int getChatCreate() {
		return chatCreate;
	}
	public void setChatCreate(int chatCreate) {
		this.chatCreate = chatCreate;
	}
	public String getChatFile() {
		return chatFile;
	}
	public void setChatFile(String chatFile) {
		this.chatFile = chatFile;
	}
	
	
	

}

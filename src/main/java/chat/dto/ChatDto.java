package chat.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias(value="chatDto")
public class ChatDto {
	private int chatId;
	private int fromId;
	private int toId;
	private String chatContent;
	private Date chatDate;
	
	
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

	public Date getChatDate() {
		return chatDate;
	}
	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}
	
	

}

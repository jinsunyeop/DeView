package chat.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import chat.dto.ChatDto;

@Repository
public class ChatDaoRepo implements ChatDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ChatDaoRepo (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int createChat(int fromId, int toId) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("fromId", fromId);
		map.put("toId", toId);
		sqlSessionTemplate.insert("createChat",map);
		int chatId = (int) map.get("chatId");
		return chatId;
	}

	@Override
	public List<ChatDto> chatById(int fromId, int toId) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("fromId", fromId);
		map.put("toId", toId);
		return sqlSessionTemplate.selectList("chatById",map);
	}

	@Override
	public void insertChat(ChatDto chatDto) {
		sqlSessionTemplate.insert("insertChat",chatDto);
		
	}

	@Override
	public ChatDto createChatDate(int chatId) {
		return 	sqlSessionTemplate.selectOne("createChatDate",chatId);
	}

	@Override
	public void insertFile(ChatDto chatDto) {
		sqlSessionTemplate.insert("insertFile",chatDto);
	}

}

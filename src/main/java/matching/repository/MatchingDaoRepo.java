package matching.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import matching.dto.MatchingDto;

@Repository 
public class MatchingDaoRepo implements MatchingDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	public MatchingDaoRepo (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	

	
	@Override
	public MatchingDto selectMatching(int request, int apply) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("request", request);
		map.put("apply", apply);
		return 	sqlSessionTemplate.selectOne("selectMatching",map);		 //전체 조회

	}

	
	@Override
	public List<MatchingDto> selectRequest(int request) {
		return sqlSessionTemplate.selectList("selectRequest",request);
	}



	@Override
	public List<MatchingDto> selectApply(int apply) {
		return sqlSessionTemplate.selectList("selectApply",apply);
	}
	
	
	@Override
	public void requestMatching(int request, int apply) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("request", request);
		map.put("apply", apply);
		sqlSessionTemplate.insert("requestMatching",map);		
	}



	@Override
	public void matchingCancel(int request, int apply) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("request", request);
		map.put("apply", apply);
		sqlSessionTemplate.delete("matchingCancel",map);				
	}



	@Override
	public void updateMatching(int request, int apply) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("request", request);
		map.put("apply", apply);
		sqlSessionTemplate.update("updateMatching",map);	
	}



	@Override
	public List<MatchingDto> completeMatching(int uId) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("request", uId);
		map.put("apply", uId);
		return sqlSessionTemplate.selectList("completeMatching",map);	
	}






}

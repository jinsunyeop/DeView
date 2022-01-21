package deview.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import deview.dto.DeviewDto;

@Repository
public class DeviewDaoRepo implements DeviewDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public DeviewDaoRepo (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	

	@Override
	public DeviewDto selectDeview(int userId) {
		return 	sqlSessionTemplate.selectOne("selectDeview",userId);		 //전체 조회
	}
	
	
	@Override
	public List<DeviewDto> deviewAllList() {
		return 	sqlSessionTemplate.selectList("deviewAllList");		 //전체 조회
	}

	@Override
	public int countDeview() {
		return 	sqlSessionTemplate.selectOne("countDeview");	
	}

	
	@Override
	public void insertDeview(DeviewDto Deview) {
		sqlSessionTemplate.insert("insertDeview",Deview);		
	}


	@Override
	public void updateDeview(DeviewDto Deview) {
		sqlSessionTemplate.insert("updateDeview",Deview);		
	}


	@Override
	public void deleteDeview(int devId) {
		sqlSessionTemplate.insert("deleteDeview",devId);		
	}


	@Override
	public List<DeviewDto> pagingDeviewList(int start, int count) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("count", count);
		return sqlSessionTemplate.selectList("pagingDeviewList",map);
	}


	@Override
	public List<DeviewDto> deviewBigcate(String devBigcate) {
		return sqlSessionTemplate.selectList("deviewBigcate",devBigcate);
	}


	@Override
	public List<DeviewDto> deviewSearch1(String devTitle) {
		return sqlSessionTemplate.selectList("deviewSearch1",devTitle);
	}


	@Override
	public List<DeviewDto> deviewSearch2(String profileNick) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("deviewSearch2",profileNick);
	}


	@Override
	public List<DeviewDto> deviewSearch3(String all) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("devTitle", all);
		map.put("profileNick", all);	
		return sqlSessionTemplate.selectList("deviewSearch3",map);
	}


	@Override
	public DeviewDto selectWithMatchingCount(int apply, int dev) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("apply", apply);
		map.put("dev", dev);
     
		return sqlSessionTemplate.selectOne("selectWithMatchingCount",map);		 //전체 조회
	}


	@Override
	public List<DeviewDto> deviewSearch(String devTitle) {
		return sqlSessionTemplate.selectList("deviewSearch",devTitle);
	}




}

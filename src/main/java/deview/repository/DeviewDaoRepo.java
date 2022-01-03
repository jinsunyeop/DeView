package deview.repository;

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

}
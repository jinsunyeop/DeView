package user.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import user.dto.ProfileDto;

@Repository
public  class ProfileDaoRepo implements ProfileDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public ProfileDaoRepo (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	@Override
	public void insertProfile(ProfileDto profile) {
		sqlSessionTemplate.insert("insertProfile",profile);		
		
	}

	@Override
	public int updateProfile(ProfileDto profile) {
		return sqlSessionTemplate.update("updateProfile",profile);
	}


	@Override
	public ProfileDto selectProfile(int userId) {
		return sqlSessionTemplate.selectOne("selectProfile",userId);
		}
	
	

}

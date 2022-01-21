package user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import user.dto.UserDto;


@Repository
public class UserDaoRepo implements UserDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public UserDaoRepo (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	
	public List<UserDto> list() {
		return sqlSessionTemplate.selectList("userList");

	}



	@Override
	public String selectGender(int userId) {
		return sqlSessionTemplate.selectOne("selectGender", userId);

	}
	
	public UserDto selectId(int userId) {
		return sqlSessionTemplate.selectOne("selectById", userId);
	}

	public int deleteUser(UserDto user) {
		return sqlSessionTemplate.delete("deleteUser",user);
	}

	public int updateMeber(UserDto user) {
		return sqlSessionTemplate.update("updateUser",user);

	}

	public void insertUser(UserDto user) {
		sqlSessionTemplate.insert("insertUser",user);		
	}


	public UserDto selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("selectByEmail",email);	
	}


	public int changePw(UserDto user) {
		return sqlSessionTemplate.update("changePw",user);

	}


	@Override
	public int check(String userEmail) {
		return sqlSessionTemplate.selectOne("checkId",userEmail);	
	}


}

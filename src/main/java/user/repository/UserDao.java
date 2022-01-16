package user.repository;

import java.util.List;

import user.dto.UserDto;



public interface UserDao {
	
	public abstract List<UserDto> list(); //모든 유저를 조회하는 메서드
	
	public abstract String selectGender(int userId); //ID를 통해 유저를 조회하는 메서드
	
	public abstract UserDto selectId(int userId); //ID를 통해 유저를 조회하는 메서드
	
	public abstract int deleteUser(UserDto user); //유저 정보를 삭제하는 메서드

	public abstract int updateMeber(UserDto user); //유저 정보를 수정하는 메서드

	public abstract void insertUser(UserDto user); //유저 정보를 저장하는 메서드

	public abstract int changePw(UserDto user); //비밀번호 수정
	
	public abstract UserDto selectByEmail(String email); //이메일을 통해 유저 조회하는 메서드
}

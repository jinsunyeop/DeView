package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.DoNotAgreeException;
import exception.MemberNotMatchingException;
import exception.PwNotMatchingException;
import user.dto.UserDto;
import user.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public void setMemberDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//유저 가입
	public void insertUser(UserDto user) {
		userDao.insertUser(user);
	}
	
	//유저 성별 조회
	public String selectGender(int userId) {
		return userDao.selectGender(userId);
	}
	
	public String checkEmail(String userEmail) {
		String agree = "false";
		String reject = "true";
		int check =userDao.check(userEmail);
		if(check==0) {
			return agree;
		}else {
			return reject;
		}
		
		
	}
	
	//유저 조회
	public UserDto selectId(int userId) {
		return userDao.selectId(userId);
	}
	
	
	//비밀번호 변경 
	public void changePw(String email,String currentPw,String newPw) {
		UserDto user = userDao.selectByEmail(email);
		if(user==null) {
			throw new MemberNotMatchingException();
		}
		user.changePassword(currentPw, newPw);
		userDao.changePw(user);
	}
	
	
	//유저 로그인
	public UserDto login(String email,String pw) {
		UserDto user = userDao.selectByEmail(email);
		if(user == null) {
			throw new MemberNotMatchingException();
		}
		if(!user.matchPw(pw)) {
			throw new PwNotMatchingException();
		}
		
		return user;
	}

	
	//회원 탈퇴
	public void delete(String email,boolean agree,String password) {
		UserDto user = userDao.selectByEmail(email);
		if(user == null) {
			throw new MemberNotMatchingException();
		}
		if(!user.matchPw(password)) {
			throw new PwNotMatchingException();
		}
		if(!agree) {
			throw new DoNotAgreeException();
		}
		userDao.deleteUser(user);
		
	}
}

package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dto.MemberNotMatchingException;
import user.dto.UserDto;
import user.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public void setMemberDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void insertUser(UserDto user) {
		userDao.insertUser(user);
	}
	
	public void changePw(String email,String currentPw,String newPw) {
		UserDto user = userDao.selectByEmail(email);
		if(user==null) {
			throw new MemberNotMatchingException();
		}
		user.changePassword(currentPw, newPw);
		userDao.changePw(user);
	}
	

}

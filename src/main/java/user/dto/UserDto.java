package user.dto;

import org.apache.ibatis.type.Alias;

import exception.PwNotMatchingException;

@Alias(value = "userDto")
public class UserDto {
	private int userId; //primary key 유저 번호
	private String userName; //유저 이름
	private String userGender; //유저 성별
	private String userEmail; //유저 이메일
	private String userPassword; //유저 비밀번호
	private boolean userStatus; // 관리자 여부
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUserStatus() {
		return userStatus;
	}
	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}
	public boolean matchPw(String password) {
		return this.userPassword.equals(password);
	}
	public void changePassword(String currentPw,String newPw) {
		if(!userPassword.equals(currentPw))
			throw new PwNotMatchingException();
		this.userPassword=newPw;
	}


}
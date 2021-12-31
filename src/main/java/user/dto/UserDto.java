package user.dto;

import org.apache.ibatis.type.Alias;

import exception.PwNotMatchingException;

@Alias(value = "userDto")
public class UserDto {
	private int userId; //primary key
	private String birth; //나이
	private String name; //이름
	private String nickname; //닉네임
	private String gender; //성별
	private String email; //이메일 
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matchPw(String password) {
		return this.password.equals(password);
	}
	public void changePassword(String currentPw,String newPw) {
		if(!password.equals(currentPw))
			throw new PwNotMatchingException();
		this.password=newPw;
	}


}
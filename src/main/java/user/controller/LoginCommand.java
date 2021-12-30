package user.controller;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginCommand {
	
	@NotEmpty(message="이메일을 입력하세요")
	private String email;
	@NotEmpty(message="비밀번호를 입력하세요.")
	private String password;
	private boolean rememberEmail;
	
	public LoginCommand() {
		
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
	public boolean isRememberEmail() {
		return rememberEmail;
	}
	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}

}

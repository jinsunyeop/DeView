package user.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class DeleteCommand {

	private boolean agree;

	@NotEmpty(message="필수 항목입니다.")
	private String password;

	@NotEmpty(message="필수 항목입니다.")
	private String email;

	@Override
	public String toString() {
		return "DeleteCommand [agree=" + agree + ", password=" + password + ", email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}

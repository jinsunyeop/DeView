package user.controller;

import org.hibernate.validator.constraints.NotEmpty;

public class chagePwCommand {
	
	@NotEmpty(message="필수 항목입니다.")
	private String currentPassword;
	@NotEmpty(message="필수 항목입니다.")
	private String newPassword;
	
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
	
}

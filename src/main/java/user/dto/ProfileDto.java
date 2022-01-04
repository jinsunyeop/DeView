package user.dto;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

@Alias(value = "ProfileDto")
public class ProfileDto {
	private int profileId;
	private int userId;
	@Length(min=2,max=20,message="주소는 2자 이상, 20자 미만 입력해야합니다.")
	private String profileGit;
	@Length(min=2,max=10,message="닉네임은 2자 이상, 10자 미만 입력해야합니다.")
	private String profileNick;
	private String profileImg;
	private String profileJob;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProfileGit() {
		return profileGit;
	}
	public void setProfileGit(String profileGit) {
		this.profileGit = profileGit;
	}
	public String getProfileNick() {
		return profileNick;
	}
	public void setProfileNick(String profileNick) {
		this.profileNick = profileNick;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getProfileJob() {
		return profileJob;
	}
	public void setProfileJob(String profileJob) {
		this.profileJob = profileJob;
	}
	
	public ProfileDto() {
		super();
	}
	public ProfileDto(int userId, String profileGit, String profileNick, String profileImg, String profileJob) {
		super();
		this.userId = userId;
		this.profileGit = profileGit;
		this.profileNick = profileNick;
		this.profileImg = profileImg;
		this.profileJob = profileJob;
	}

	


}

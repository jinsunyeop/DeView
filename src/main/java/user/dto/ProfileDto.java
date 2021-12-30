package user.dto;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

@Alias(value = "ProfileDto")
public class ProfileDto {
	private int userId;
	@Length(min=2,max=20,message="주소는 2자 이상, 20자 미만 입력해야합니다.")
	private String gitAdd;
	private String imgName;
	//학력
	//기술
	//자격증
	//희망직군
	
	public ProfileDto() {
	}
	
	
	
	public ProfileDto(int userId, String gitAdd, String imgName) {
		super();
		this.userId = userId;
		this.gitAdd = gitAdd;
		this.imgName = imgName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGitAdd() {
		return gitAdd;
	}
	public void setGitAdd(String gitAdd) {
		this.gitAdd = gitAdd;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}

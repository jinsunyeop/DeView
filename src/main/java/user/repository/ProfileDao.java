package user.repository;

import user.dto.ProfileDto;

public interface ProfileDao {
	public abstract ProfileDto selectProfile(int userId);
	public abstract int countProfile(int userId);
	public abstract void insertProfile(ProfileDto profile); //프로필 정보를 저장하는 메서드
	public abstract int updateProfile(ProfileDto profile); //프로필 정보를 수정하는 메서드
	

}

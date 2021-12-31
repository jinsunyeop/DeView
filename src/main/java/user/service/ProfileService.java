package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dto.ProfileDto;
import user.repository.ProfileDao;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileDao profileDao;

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	
	public ProfileDto selectProfile(int userId) {
		ProfileDto profile = profileDao.selectProfile(userId);	
		return profile;
	}
	
	public void insertProfile(ProfileDto profile) {
		profileDao.insertProfile(profile);
		
	}
	
	public void updateProfile(ProfileDto profile) {
		profileDao.updateProfile(profile);
		
	}
	
	public int countProfile(int userId) {
		return profileDao.countProfile(userId);
	}
	
	
	

}

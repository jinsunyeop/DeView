package matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matching.dto.MatchingDto;
import matching.repository.MatchingDao;

@Service
public class MatchingService {
	
	@Autowired
	MatchingDao matchingDao;

	public void setMatchingDao(MatchingDao matchingDao) {
		this.matchingDao = matchingDao;
	}
	
	public MatchingDto selectMatching(int request, int apply) {
		MatchingDto matching = matchingDao.selectMatching(request, apply);
		return matching;
	}
	
	public List<MatchingDto> selectRequest(int request) {
		return matchingDao.selectRequest(request);
	}	
	
	public List<MatchingDto> selectApply(int apply) {
		return matchingDao.selectApply(apply);
	}	
	
	
	
	public void requestMatching(int request, int apply) {
		matchingDao.requestMatching(request, apply);
	}
	
	public void matchingCancel(int request, int apply) {
		matchingDao.matchingCancel(request, apply);
	}
	
	public void updateMatching(int request, int apply) {
		matchingDao.updateMatching(request, apply);
	}
	
	public List<MatchingDto> completeMatching1(int request) {
		return matchingDao.completeMatching1(request);
	}	
	
	public List<MatchingDto> completeMatching2(int apply) {
		return matchingDao.completeMatching2(apply);
	}	
}

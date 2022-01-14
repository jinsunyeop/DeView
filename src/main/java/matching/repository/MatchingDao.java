package matching.repository;

import java.util.List;

import matching.dto.MatchingDto;

public interface MatchingDao {
	
	public abstract MatchingDto selectMatching(int request,int apply);
	public abstract List<MatchingDto> selectRequest(int request);
	public abstract List<MatchingDto> selectApply(int apply);
	public abstract void requestMatching(int request,int apply);
	public abstract void deleteMatching(int request,int apply);
	public abstract void updateMatching(int request,int apply);

	
	

}

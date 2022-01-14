package matching.dto;

import org.apache.ibatis.type.Alias;

@Alias(value="matchingDto")
public class MatchingDto {
	
	private String matchingId;
	private String matchingRequest;
	private String matchingApply;
	private boolean matchingStatus;

	public String getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(String matchingId) {
		this.matchingId = matchingId;
	}
	public String getMatchingRequest() {
		return matchingRequest;
	}
	public void setMatchingRequest(String matchingRequest) {
		this.matchingRequest = matchingRequest;
	}
	public String getMatchingApply() {
		return matchingApply;
	}
	public void setMatchingApply(String matchingApply) {
		this.matchingApply = matchingApply;
	}
	public boolean isMatchingStatus() {
		return matchingStatus;
	}
	public void setMatchingStatus(boolean matchingStatus) {
		this.matchingStatus = matchingStatus;
	}




}

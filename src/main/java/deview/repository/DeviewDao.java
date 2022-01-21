package deview.repository;

import java.util.List;

import deview.dto.DeviewDto;

public interface DeviewDao {
	
	public abstract DeviewDto selectDeview(int userId);
	public abstract DeviewDto selectWithMatchingCount(int apply,int dev);
	
	public abstract List<DeviewDto> deviewAllList(); //DEVIEW 전체 조회
	public abstract int countDeview(); //DEVIEW 갯수
	public abstract void insertDeview(DeviewDto Deview); //DEVIEW 정보를 저장하는 메서드
	public abstract void updateDeview(DeviewDto Deview); //DEVIEW 정보를 수정하는 메서드
	public abstract void deleteDeview(int devId); //DEVIEW 정보를 수정하는 메서드
	public abstract List<DeviewDto> pagingDeviewList(int start,int count); 
	public abstract List<DeviewDto> deviewBigcate(String devBigcate); 
	public abstract List<DeviewDto> deviewSearch1(String devTitle); 
	public abstract List<DeviewDto> deviewSearch2(String profileNick);
	public abstract List<DeviewDto> deviewSearch3(String all);
	public abstract List<DeviewDto> deviewSearch(String devTitle);

	
	
}

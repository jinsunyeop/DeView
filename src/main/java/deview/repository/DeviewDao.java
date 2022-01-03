package deview.repository;

import java.util.List;

import deview.dto.DeviewDto;

public interface DeviewDao {
	public abstract List<DeviewDto> deviewAllList(); //DEVIEW 전체 조회
	public abstract int countDeview(); //DEVIEW 갯수
	public abstract void insertDeview(DeviewDto Deview); //프로필 정보를 저장하는 메서드
	
	
}

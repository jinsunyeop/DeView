package deview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deview.dto.DeviewDto;
import deview.repository.DeviewDao;

@Service
public class DeviewService {
	
	@Autowired
	private DeviewDao deviewDao;

	public DeviewDto selectDeview(int userId) {
		return deviewDao.selectDeview(userId);
	}
	
	public List<DeviewDto> listDeview() {  //전체 조회
		return deviewDao.deviewAllList();
	}
	
	public int countDeview () {  //갯수
		return deviewDao.countDeview();
	}
	
	public void insertDeview(DeviewDto deview) {
		 deviewDao.insertDeview(deview);
	}
	
	
	
	
}

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
	
	public DeviewDto selectWithMatchingCount(int apply,int id) {
		return deviewDao.selectWithMatchingCount(apply,id);
	}
	
	
	public List<DeviewDto> listDeview() {  //전체 조회
		return deviewDao.deviewAllList();
	}
	
	public List<DeviewDto> pagingDeviewList(int start,int count) {  //페이징 리스트 조회
		return deviewDao.pagingDeviewList(start,count);
	}
	
	public List<DeviewDto> deviewBigcate(String devBigcate) {  //전체 조회
		return deviewDao.deviewBigcate(devBigcate);
	}
	
	
	public int countDeview () {  //갯수
		return deviewDao.countDeview();
	}
	
	public void insertDeview(DeviewDto deview) {
		 deviewDao.insertDeview(deview);
	}
	
	public void updateDeview(DeviewDto deview) {
		 deviewDao.updateDeview(deview);
	}
	
	public void deleteDeview(int userId) {
		 deviewDao.deleteDeview(userId);
	}
	
	public List<DeviewDto> deviewSearch(String devTitle) {
		return deviewDao.deviewSearch(devTitle);
	}
	
	public List<DeviewDto> deviewSearch1(String devTitle){
		return deviewDao.deviewSearch1(devTitle);
	}

	public List<DeviewDto> deviewSearch2(String profileNick){
		return deviewDao.deviewSearch2(profileNick);
	}
	
	public List<DeviewDto> deviewSearch3(String all){
		return deviewDao.deviewSearch3(all);
	}
	
}

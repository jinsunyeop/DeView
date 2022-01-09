package deview.dto;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;


@Alias(value = "deviewDto")
public class DeviewDto {
	private int devId;
	private int userId;
    @Size(min = 2, max = 20,message="제목은 20자리까지 가능합니다.")
	@NotEmpty
	private String devTitle; //제목
	@NotEmpty
	private String devBigcate; //주요 언어
	@NotEmpty
	private String devSmallcate; //직무
	@NotEmpty
	private String devContent; //내용
	
	@NotEmpty
	private String devNumber; //번호
	private Date devDate; //개설 날짜
	
	@NotNull	
	@Digits(integer = 7, fraction = 0,message="100만원 미만이며 소수점을 허용하지 않습니다.")
	private int devPrice; //리뷰당 가격

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDevTitle() {
		return devTitle;
	}

	public void setDevTitle(String devTitle) {
		this.devTitle = devTitle;
	}

	public String getDevBigcate() {
		return devBigcate;
	}

	public void setDevBigcate(String devBigcate) {
		this.devBigcate = devBigcate;
	}

	public String getDevSmallcate() {
		return devSmallcate;
	}

	public void setDevSmallcate(String devSmallcate) {
		this.devSmallcate = devSmallcate;
	}

	public String getDevContent() {
		return devContent;
	}

	public void setDevContent(String devContent) {
		this.devContent = devContent;
	}

	public String getDevNumber() {
		return devNumber;
	}

	public void setDevNumber(String devNumber) {
		this.devNumber = devNumber;
	}

	public Date getDevDate() {
		return devDate;
	}

	public void setDevDate(Date devDate) {
		this.devDate = devDate;
	}

	public int getDevPrice() {
		return devPrice;
	}

	public void setDevPrice(int devPrice) {
		this.devPrice = devPrice;
	}
	
	
	
	
	
	
	
}

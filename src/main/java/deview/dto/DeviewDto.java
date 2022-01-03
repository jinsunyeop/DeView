package deview.dto;

import org.apache.ibatis.type.Alias;

@Alias(value = "deviewDto")
public class DeviewDto {
	private int deviewId;
	private int userId;
	private String title; //제목
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String content; //내용
	private String career; //경력 사항
	private String contact; //컨텍 메일
	private String number; //번호
	private int price; //가격
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDeviewId() {
		return deviewId;
	}
	public void setDeviewId(int deviewId) {
		this.deviewId = deviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}

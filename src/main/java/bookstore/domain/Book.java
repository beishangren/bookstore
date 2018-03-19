package bookstore.domain;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
public class Book extends DomainObject{
	public Book() {
		
	}
	public Book(Long id,String name,Integer price,String image,Integer number) {
		super(id);
		this.name = name;
		this.price=price;
		this.image=image;
		this.number=number;
		}
	
	//书名
	private String name;
	//价格
	
	private Integer price;
	//图片
	
	private String image;
	//数量
	private Integer number;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	
}

package bookstore.domain;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
public class Order extends DomainObject{
	public Order() {
		
	}
	public Order(Long id,String name,String bookName,Integer price,String state,long userId) {
		super(id);
		this.name = name;
		this.bookName=bookName;
		this.price=price;
		this.state=state;
		this.userId=userId;
		}
	
	//书名
	private String name;
	//价格
	private String bookName;
	
	private Integer price;
	//图片
	
	private String state;
	
	private long userId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}

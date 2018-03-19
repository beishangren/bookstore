package bookstore.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import bookstore.entity.AbstractEntity;
@Entity
public class BookEntity extends AbstractEntity 
{	
	
	private String name;
	
	private Integer price;
	@Lob //表示该属性是 LOB 类型的字段
	@Basic(fetch = FetchType.EAGER) //不采用延迟加载机制
	@Column(name = "image", columnDefinition = "LONGBLOB NOT NULL") //对应字段类型
	private String image;
	
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

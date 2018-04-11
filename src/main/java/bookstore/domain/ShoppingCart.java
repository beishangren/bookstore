package bookstore.domain;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
public class ShoppingCart extends DomainObject{
	public ShoppingCart() {
		
	}
	public ShoppingCart(Long id,long userId,long goodsId,String bookName,Integer bookPrice) {
		super(id);
		this.userId = userId;
		this.goodsId= goodsId;
		this.bookName= bookName;
		this.bookPrice= bookPrice;
		}
	private long userId;
	private long goodsId;
	private String bookName;
	private  Integer bookPrice;
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	
}

package bookstore.domain;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
public class GoodsProcess extends DomainObject{
	public GoodsProcess() {
		
	}
	public GoodsProcess(Long id,Integer userId,Integer goodsId,String state) {
		super(id);
		this.userId = userId;
		this.goodsId= goodsId;
		this.state = state;
		}
	private Integer userId;
	private Integer goodsId;
	private String state;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}

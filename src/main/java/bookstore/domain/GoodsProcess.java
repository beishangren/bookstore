package bookstore.domain;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
public class GoodsProcess extends DomainObject{
	public GoodsProcess() {
		
	}
	public GoodsProcess(Long id,long userId,long goodsId) {
		super(id);
		this.userId = userId;
		this.goodsId= goodsId;
		}
	private long userId;
	private long goodsId;
	
	
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

}

package bookstore.entity;

import javax.persistence.Entity;
import bookstore.entity.AbstractEntity;

@Entity
public class UsersEntity extends AbstractEntity{
	//用户名
	private String userName;
	
	//密码
	private String passWord;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}

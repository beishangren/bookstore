package bookstore.domain;

public class Users extends DomainObject{
	public Users() {
		
	}
	public Users(Long id,String userName,String passWord) {
		super(id);
		this.userName=userName;
		this.passWord=passWord;
	}
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

package clinica.model;

import javax.persistence.*;

@Entity
public class Amministratore {

	@Column(nullable=false)
	private String userName;

	@Column(nullable=false)
	private String passWord;
	
	public Amministratore(){}
	
	public Amministratore(String userName,String passWord){
		setUserName(userName);
		setPassWord(passWord);
	}

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

package clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amministratore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAmministratore;
	@Column(nullable=false)
	private String userName;

	@Column(nullable=false)
	private String passWord;
	
	public Amministratore(){}
	
	public Amministratore(String userName,String passWord){
		setUserName(userName);
		setPassWord(passWord);
	}

	
	public Long getIdAmministratore() {
		return idAmministratore;
	}

	public void setIdAmministratore(Long idAmministratore) {
		this.idAmministratore = idAmministratore;
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

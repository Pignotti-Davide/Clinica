import javax.persistence.*;

@Entity
public class Paziente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTipologiaEsame;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	
	
	public Long getIdTipologiaEsame() {
		return idTipologiaEsame;
	}


	public void setIdTipologiaEsame(Long idTipologiaEsame) {
		this.idTipologiaEsame = idTipologiaEsame;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Paziente(){}
}

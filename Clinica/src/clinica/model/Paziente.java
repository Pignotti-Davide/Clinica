package clinica.model;

import javax.persistence.*;

@Entity
public class Paziente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPaziente;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	
	
	


	public Long getIdPaziente() {
		return idPaziente;
	}


	public void setIdPaziente(Long idPaziente) {
		this.idPaziente = idPaziente;
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

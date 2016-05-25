package clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idMedico;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(nullable=false)
	private String specializzazione;


	public Medico(){}


	public Long getIdMedico() {
		return idMedico;
	}


	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
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


	public String getSpecializzazione() {
		return specializzazione;
	}


	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
	
}

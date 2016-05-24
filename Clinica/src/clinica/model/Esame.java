package clinica.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Esame {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEsame;
	
	@OneToOne
	private Medico medico;
	@OneToOne
	private Paziente paziente;
	@OneToOne
	private TipologiaEsame tipologiaEsame;
	@Column(nullable=false)
	private Date prenotazione;
	@Column(nullable=false)
	private Date esecuzioneEsame;
	@OneToMany(cascade=CascadeType.ALL)
	private Map<String,String> risultati;
	
	public Long getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(Long idEsame) {
		this.idEsame = idEsame;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Date getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Date prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Date getEsecuzioneEsame() {
		return esecuzioneEsame;
	}

	public void setEsecuzioneEsame(Date esecuzioneEsame) {
		this.esecuzioneEsame = esecuzioneEsame;
	}

	public Map<String, String> getRisultati() {
		return risultati;
	}

	public void setRisultati(Map<String, String> risultati) {
		this.risultati = risultati;
	}
	

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public Esame() {}
}


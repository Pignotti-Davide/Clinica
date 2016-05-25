package clinica.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

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
	@CollectionOfElements(targetElement=java.lang.String.class)
	@JoinTable(name="ESAME_RISULTATI",
	        joinColumns=@JoinColumn(name="ESAME_ID"))
	@MapKey (columns=@Column(name="RISULTATI_ID"))
	@Column(name="REQUISITO")
	@ElementCollection
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


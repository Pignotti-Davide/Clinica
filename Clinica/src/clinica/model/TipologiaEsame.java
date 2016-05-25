package clinica.model;

import java.util.Map;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;
@Entity
public class TipologiaEsame {
	@Column(name="TIPOLOGIA_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTipologiaEsame;
	@Column(nullable=false)
	private String nome;
	@Column
	private String descrizione;
	@CollectionOfElements(targetElement=java.lang.String.class)
	@JoinTable(name="TIPOLOGIAESAME_REQUISITI",
	        joinColumns=@JoinColumn(name="TIPOLOGIA_ID"))
	@Column(name="DESCRIZIONE")
	@MapKey (columns=@Column(name="CHAPTER_KEY"))
	
	@ElementCollection
	private Map<String,String> nomeRequisiti;
//	@OneToMany
//	private List<String> indicatoriRisultati;
//	
	public TipologiaEsame(){}

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	

	public Map<String, String> getPrerequisiti() {
		return nomeRequisiti;
	}

	public void setPrerequisiti(Map<String, String> prerequisiti) {
		this.nomeRequisiti = prerequisiti;
	}

	@Override
	public String toString() {
		return "TipologiaEsame [idTipologiaEsame=" + idTipologiaEsame + ", nome=" + nome + ", descrizione="
				+ descrizione + ", nomeRequisiti=" + nomeRequisiti + "]";
	}

//	public List<String> getIndicatoriRisultati() {
//		return indicatoriRisultati;
//	}
//
//	public void setIndicatoriRisultati(List<String> indicatoriRisultati) {
//		this.indicatoriRisultati = indicatoriRisultati;
//	}
	
}

package clinica.model;

import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTipologiaEsame;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String descrizione;
	@Column(nullable=false)
	private double costo;
	 @ElementCollection
	 @MapKeyColumn(name="name")
	    @Column(name="value")
	    @CollectionTable(name="tipologiaesame_attributes", joinColumns=@JoinColumn(name="tipologiaesame_id"))
	private Map<String,String> prerequisiti;
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

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Map<String, String> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(Map<String, String> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

//	public List<String> getIndicatoriRisultati() {
//		return indicatoriRisultati;
//	}
//
//	public void setIndicatoriRisultati(List<String> indicatoriRisultati) {
//		this.indicatoriRisultati = indicatoriRisultati;
//	}
	
}

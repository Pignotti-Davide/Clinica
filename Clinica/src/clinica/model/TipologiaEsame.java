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
	@OneToMany
	private Map<String,String> prerequisiti;
	@OneToMany
	private List<String> indicatoriRisultati;
	
	public TipologiaEsame(){}
}

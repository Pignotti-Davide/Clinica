package clinica.model;

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
	
	
	public Paziente(){}
}

package clinica.model;

import javax.persistence.*;

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
}

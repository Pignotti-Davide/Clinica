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
	@Column(nullable=false)
	private Date prenotazione;
	@Column(nullable=false)
	private Date esecuzioneEsame;
	@Column(nullable=false)
	private Map<String,String> risultati;
}

package clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Requisito {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRequisito;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String descrizione;
	public Requisito(){
		
	}
}

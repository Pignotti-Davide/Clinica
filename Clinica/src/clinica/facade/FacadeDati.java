package clinica.facade;

import java.util.List;

import clinica.model.Esame;
import clinica.model.Medico;
import clinica.model.Paziente;
import clinica.model.TipologiaEsame;
import clinica.persistence.EsameDaoJPA;
import clinica.persistence.MedicoDaoJPA;
import clinica.persistence.PazienteDaoJPA;
import clinica.persistence.TipologiaEsameDaoJPA;

public class FacadeDati {
	
	public void salvaMedico(Medico m){
		new MedicoDaoJPA().create(m);
	}
	
	public void salvaEsame(Esame e){
	new EsameDaoJPA().create(e);}
	
	public void salvaPaziente(Paziente p){
		new PazienteDaoJPA().create(p);
		
	}
	
	public void salvaTipologiaEsame(TipologiaEsame t){
		new TipologiaEsameDaoJPA().create(t);
	}
	
	public TipologiaEsame trovaTipologiaEsame(long id){
		return new TipologiaEsameDaoJPA().retrieve(id);
	}

	public Paziente trovaPaziente(long id) {
		return new PazienteDaoJPA().retrieve(id);
	}

	public Medico trovaMedico(long id) {
		return new MedicoDaoJPA().retrieve(id);
	}
	public List<TipologiaEsame> findAllTipologieEsami(){
		return new TipologiaEsameDaoJPA().findAll();
	}
	public List<Medico> findAllMedici(){
		return new MedicoDaoJPA().findAll();
	}
	public List<Paziente> findAllPazienti(){
		return new PazienteDaoJPA().findAll();
	}
	
}

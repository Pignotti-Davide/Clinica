package clinica.persistence;
import javax.persistence.RollbackException;

import clinica.model.TipologiaEsame;
public class TipologiaEsameDaoJPA {
	public void create(TipologiaEsame e) {

		try{
			Connessione.getEm().getTransaction().begin();
			Connessione.getEm().persist(e);
			Connessione.getEm().getTransaction().commit();
			Connessione.getEm().clear();				
		}
		catch (RollbackException e){
			Connessione.getEm().clear();
		}	
	}

	public TipologiaEsame retrieve(int id) {
		TipologiaEsame es=null;
		Connessione.getEm().getTransaction().begin();
		es = Connessione.getEm().find(TipologiaEsameclass, id);
		Connessione.getEm().clear();
		Connessione.getEm().getTransaction().commit();
		return es;
	}

	public void update(TipologiaEsamee) {
		Connessione.getEm().getTransaction().begin();
		Connessione.getEm().merge(e);
		Connessione.getEm().getTransaction().commit();
	}

	public void delete(TipologiaEsamee) {
		TipologiaEsame esa=null;
		Connessione.getEm().getTransaction().begin();
		esa=Connessione.getEm().find(TipologiaEsame.class, e.getId());
		Connessione.getEm().remove(esa);
		Connessione.getEm().getTransaction().commit();
	}
}

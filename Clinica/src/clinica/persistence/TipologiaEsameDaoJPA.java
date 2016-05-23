package clinica.persistence;
import javax.persistence.RollbackException;

import clinica.model.TipologiaEsame;
public class TipologiaEsameDaoJPA {
	public void create(TipologiaEsame esa) {

		try{
			Connessione.getEm().getTransaction().begin();
			Connessione.getEm().persist(esa);
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
		es = Connessione.getEm().find(TipologiaEsame.class, id);
		Connessione.getEm().clear();
		Connessione.getEm().getTransaction().commit();
		return es;
	}

	public void update(TipologiaEsame esa) {
		Connessione.getEm().getTransaction().begin();
		Connessione.getEm().merge(esa);
		Connessione.getEm().getTransaction().commit();
	}

	public void delete(TipologiaEsame e) {
		TipologiaEsame esa=null;
		Connessione.getEm().getTransaction().begin();
		esa=Connessione.getEm().find(TipologiaEsame.class, e.getIdTipologiaEsame());
		Connessione.getEm().remove(esa);
		Connessione.getEm().getTransaction().commit();
	}
}

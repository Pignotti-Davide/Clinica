package clinica.persistence;
import java.util.List;

import javax.persistence.RollbackException;

import clinica.model.Esame;
import clinica.model.Paziente;
public class EsameDaoJPA {

	public void create(Esame es) {

		try{
			Connessione.getInstance().getEm().getTransaction().begin();
			Connessione.getInstance().getEm().persist(es);
			Connessione.getInstance().getEm().getTransaction().commit();
			Connessione.getInstance().getEm().clear();				
		}
		catch (RollbackException e){
			Connessione.getInstance().getEm().clear();
		}	
	}

	public Esame retrieve(int id) {
		Esame es=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		es = Connessione.getInstance().getEm().find(Esame.class, id);
		Connessione.getInstance().getEm().clear();
		Connessione.getInstance().getEm().getTransaction().commit();
		return es;
	}

	public void update(Esame e) {
		Connessione.getInstance().getEm().getTransaction().begin();
		Connessione.getInstance().getEm().merge(e);
		Connessione.getInstance().getEm().getTransaction().commit();
	}

	public void delete(Esame e) {
		Esame esa=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		esa=Connessione.getInstance().getEm().find(Esame.class, e.getIdEsame());
		Connessione.getInstance().getEm().remove(esa);
		Connessione.getInstance().getEm().getTransaction().commit();
	}

	public List<Esame> retrieveEsamiDelPaziente(Paziente p){
		return Connessione.getInstance().getEm().createQuery("Select e From Esame e Where e.paziente="+p.getIdPaziente()).getResultList();
	}
}


package clinica.persistence;
import javax.persistence.*;
import clinica.model.Esame;
public class EsameDaoJPA {
	
	public void create(Esame es) {

		try{
			Connessione.getEm().getTransaction().begin();
			Connessione.getEm().persist(es);
			Connessione.getEm().getTransaction().commit();
			Connessione.getEm().clear();				
		}
		catch (RollbackException e){
			Connessione.getEm().clear();
		}	
	}

	public Esame retrieve(int id) {
		Esame es=null;
		Connessione.getEm().getTransaction().begin();
		es = Connessione.getEm().find(Esame.class, id);
		Connessione.getEm().clear();
		Connessione.getEm().getTransaction().commit();
		return es;
	}

	public void update(Esame e) {
		Connessione.getEm().getTransaction().begin();
		Connessione.getEm().merge(e);
		Connessione.getEm().getTransaction().commit();
	}

	public void delete(Esame e) {
		Esame esa=null;
		Connessione.getEm().getTransaction().begin();
		esa=Connessione.getEm().find(Esame.class, e.getIdEsame());
		Connessione.getEm().remove(esa);
		Connessione.getEm().getTransaction().commit();
	}
}

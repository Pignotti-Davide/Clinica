package clinica.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import clinica.model.Paziente;


public class PazienteDaoJPA {
	
	
	public void create(Paziente p) {

		try{
			Connessione.getInstance().getEm().getTransaction().begin();
			Connessione.getInstance().getEm().persist(p);
			Connessione.getInstance().getEm().getTransaction().commit();
			Connessione.getInstance().getEm().clear();
		}
		catch (RollbackException e){
			Connessione.getInstance().getEm().clear();
		}
	}

	public Paziente retrieve(long codPaziente) {
		Paziente paz=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		paz = Connessione.getInstance().getEm().find(Paziente.class, codPaziente);
		Connessione.getInstance().getEm().clear();
		Connessione.getInstance().getEm().getTransaction().commit();
		return paz;
	}
	
	public List<Paziente> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		List<Paziente> list = em.createQuery("SELECT p FROM Paziente p").getResultList();
		tx.commit();
		return list;
	}
	
	

	public void update(Paziente p) {
		Connessione.getInstance().getEm().getTransaction().begin();
		Connessione.getInstance().getEm().merge(p);
		Connessione.getInstance().getEm().getTransaction().commit();


	}

	public void delete(Paziente p) {
		Paziente paz=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		paz=Connessione.getInstance().getEm().find(Paziente.class, p.getIdPaziente());
		Connessione.getInstance().getEm().remove(paz);
		Connessione.getInstance().getEm().getTransaction().commit();

	}
}

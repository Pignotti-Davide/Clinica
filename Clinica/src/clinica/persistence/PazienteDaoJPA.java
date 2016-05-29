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
			Connessione.getEm().getTransaction().begin();
			Connessione.getEm().persist(p);
			Connessione.getEm().getTransaction().commit();
			Connessione.getEm().clear();
		}
		catch (RollbackException e){
			Connessione.getEm().clear();
		}
	}

	public Paziente retrieve(long codPaziente) {
		Paziente paz=null;
		Connessione.getEm().getTransaction().begin();
		paz = Connessione.getEm().find(Paziente.class, codPaziente);
		Connessione.getEm().clear();
		Connessione.getEm().getTransaction().commit();
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
		Connessione.getEm().getTransaction().begin();
		Connessione.getEm().merge(p);
		Connessione.getEm().getTransaction().commit();


	}

	public void delete(Paziente p) {
		Paziente paz=null;
		Connessione.getEm().getTransaction().begin();
		paz=Connessione.getEm().find(Paziente.class, p.getIdPaziente());
		Connessione.getEm().remove(paz);
		Connessione.getEm().getTransaction().commit();

	}
}

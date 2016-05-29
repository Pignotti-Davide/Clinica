package clinica.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import clinica.model.Medico;

public class MedicoDaoJPA {

	public void create(Medico m) {

		try{
			Connessione.getInstance().getEm().getTransaction().begin();
			Connessione.getInstance().getEm().persist(m);
			Connessione.getInstance().getEm().getTransaction().commit();
			Connessione.getInstance().getEm().clear();				
		}
		catch (RollbackException e){
			Connessione.getInstance().getEm().clear();
		}	
	}

	public Medico retrieve(Long id) {
		Medico med=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		med = Connessione.getInstance().getEm().find(Medico.class,id);
		Connessione.getInstance().getEm().clear();
		Connessione.getInstance().getEm().getTransaction().commit();
		return med;
	}

	public void update(Medico m) {
		Connessione.getInstance().getEm().getTransaction().begin();
		Connessione.getInstance().getEm().merge(m);
		Connessione.getInstance().getEm().getTransaction().commit();
	}

	public void delete(Medico m) {
		Medico med=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		med=Connessione.getInstance().getEm().find(Medico.class, m.getIdMedico());
		Connessione.getInstance().getEm().remove(med);
		Connessione.getInstance().getEm().getTransaction().commit();
	}
	public List<Medico> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		List<Medico> list = em.createQuery("SELECT m FROM Medico m").getResultList();
		tx.commit();
		return list;
	}
}

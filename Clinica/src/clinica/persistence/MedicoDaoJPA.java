package clinica.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import clinica.model.Medico;
import clinica.model.TipologiaEsame;

public class MedicoDaoJPA {

	public void create(Medico m) {

		try{
			Connessione.getEm().getTransaction().begin();
			Connessione.getEm().persist(m);
			Connessione.getEm().getTransaction().commit();
			Connessione.getEm().clear();				
		}
		catch (RollbackException e){
			Connessione.getEm().clear();
		}	
	}

	public Medico retrieve(Long id) {
		Medico med=null;
		Connessione.getEm().getTransaction().begin();
		med = Connessione.getEm().find(Medico.class,id);
		Connessione.getEm().clear();
		Connessione.getEm().getTransaction().commit();
		return med;
	}

	public void update(Medico m) {
		Connessione.getEm().getTransaction().begin();
		Connessione.getEm().merge(m);
		Connessione.getEm().getTransaction().commit();
	}

	public void delete(Medico m) {
		Medico med=null;
		Connessione.getEm().getTransaction().begin();
		med=Connessione.getEm().find(Medico.class, m.getIdMedico());
		Connessione.getEm().remove(med);
		Connessione.getEm().getTransaction().commit();
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

package clinica.persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import clinica.model.TipologiaEsame;
public class TipologiaEsameDaoJPA {
	public void create(TipologiaEsame esa) {

		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		

			EntityManager em = emf.createEntityManager();
	
			EntityTransaction tx=em.getTransaction();
	
			tx.begin();
			System.out.print(esa.toString());
			em.persist(esa);
			tx.commit();
			em.close();
			emf.close();
	}

	public TipologiaEsame retrieve(long id) {
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
	public List<TipologiaEsame> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		List<TipologiaEsame> list = em.createQuery("SELECT t FROM TipologiaEsame t").getResultList();
		tx.commit();
		return list;
	}
}

package clinica.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import clinica.persistence.TipologiaEsameDaoJPA;

public class Prove {
	public static void main(String[] argw){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
	
	em.close();
	emf.close();
	}
}

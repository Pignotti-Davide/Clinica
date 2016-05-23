package clinica.model;

import javax.persistence.*;

public class Prove {
	public static void main(String[] argw){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
	}
}

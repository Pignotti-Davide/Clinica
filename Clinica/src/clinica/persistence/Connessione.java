package clinica.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Connessione {
	private static  Connessione instance;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static Connection c;

	public Connessione(){
		emf=Persistence.createEntityManagerFactory("clinica-unit");
		em=emf.createEntityManager();
		try {
			c=DriverManager.getConnection("jdbc:postgresql://localhost/clinica");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public synchronized static Connessione getInstance() {
	if(instance==null)
		instance=new Connessione();
		return instance;
		}
	
	public static void closeConnection(){
		em.close();
		emf.close();
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static EntityManagerFactory getEmf() {
		return emf;
	}
	
	public static void setEmf(EntityManagerFactory emf) {
		Connessione.emf = emf;
	}
	
	public EntityManager getEm() {
		return em;
	}
	
	public void setEm(EntityManager em) {
		Connessione.em = em;
	}

	public static Connection getC() {
		return c;
	}
}
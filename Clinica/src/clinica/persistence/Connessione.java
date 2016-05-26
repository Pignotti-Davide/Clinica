package clinica.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.*;

public class Connessione {
	public static final Connessione instance=new Connessione();
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
	


	public void salvaOggetto(Object object){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist((object.getClass().cast(object)));
		tx.commit();
	}
	public void rimuoviOggetto(Object object){
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setEmf(EntityManagerFactory emf) {
		Connessione.emf = emf;
	}

	public static EntityManager getEm() {
		return em;
	}

	public static void setEm(EntityManager em) {
		Connessione.em = em;
	}

	public static Connection getC() {
		return c;
	}
	

}
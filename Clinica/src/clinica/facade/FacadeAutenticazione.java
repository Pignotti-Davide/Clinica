package clinica.facade;
import javax.persistence.EntityManager;

import clinica.model.Utente;
import clinica.persistence.Connessione;

public  class FacadeAutenticazione {
	private EntityManager em;
		public Utente login(String username, String password){
			Connessione.getEm().getTransaction().begin();
			Utente u= 	Connessione.getEm().find(Utente.class, username);
			Connessione.getEm().getTransaction().commit();
			Connessione.getEm().clear();				
			System.out.println(username);
			System.out.println(password);
			
			System.out.println(u);
			return u;
		}
		public EntityManager getEm() {
			return em;
		}
		public void setEm(EntityManager em) {
			this.em = em;
		}
		
	}

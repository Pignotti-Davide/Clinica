package clinica.persistence;

import javax.persistence.RollbackException;

import clinica.model.Amministratore;


public class AmministratoreDaoJPA {

	public void create(Amministratore a) {

		try{
			Connessione.getEm().getTransaction().begin();
			Connessione.getEm().persist(a);
			Connessione.getEm().getTransaction().commit();
			Connessione.getEm().clear();				
		}
		catch (RollbackException e){
			Connessione.getEm().clear();
		}	
	}

	public Amministratore retrieve(Amministratore a) {
		Amministratore amm=null;
		Connessione.getEm().getTransaction().begin();
		amm = Connessione.getEm().find(Amministratore.class, a.getIdAmministratore());
		Connessione.getEm().clear();
		Connessione.getEm().getTransaction().commit();
		return amm;


	}

	public void update(Amministratore a) {
		Connessione.getEm().getTransaction().begin();
		Connessione.getEm().merge(a);
		Connessione.getEm().getTransaction().commit();


	}

	public void delete(Amministratore a) {
		Amministratore amm=null;
		Connessione.getEm().getTransaction().begin();
		amm=Connessione.getEm().find(Amministratore.class, a);
		Connessione.getEm().remove(amm);
		Connessione.getEm().getTransaction().commit();

	}
}

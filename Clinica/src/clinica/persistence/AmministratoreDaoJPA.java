package clinica.persistence;

import javax.persistence.RollbackException;

import clinica.model.Amministratore;


public class AmministratoreDaoJPA {

	public void create(Amministratore a) {

		try{
			Connessione.getInstance().getEm().getTransaction().begin();
			Connessione.getInstance().getEm().persist(a);
			Connessione.getInstance().getEm().getTransaction().commit();
			Connessione.getInstance().getEm().clear();				
		}
		catch (RollbackException e){
			Connessione.getInstance().getEm().clear();
		}	
	}

	public Amministratore retrieve(Amministratore a) {
		Amministratore amm=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		amm = Connessione.getInstance().getEm().find(Amministratore.class, a.getIdAmministratore());
		Connessione.getInstance().getEm().clear();
		Connessione.getInstance().getEm().getTransaction().commit();
		return amm;


	}

	public void update(Amministratore a) {
		Connessione.getInstance().getEm().getTransaction().begin();
		Connessione.getInstance().getEm().merge(a);
		Connessione.getInstance().getEm().getTransaction().commit();


	}

	public void delete(Amministratore a) {
		Amministratore amm=null;
		Connessione.getInstance().getEm().getTransaction().begin();
		amm=Connessione.getInstance().getEm().find(Amministratore.class, a);
		Connessione.getInstance().getEm().remove(amm);
		Connessione.getInstance().getEm().getTransaction().commit();

	}
}

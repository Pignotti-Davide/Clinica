package clinica.persistence;

import javax.persistence.RollbackException;

import clinica.model.Medico;

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

	public Medico retrieve(Medico m) {
		Medico med=null;
		Connessione.getEm().getTransaction().begin();
		med = Connessione.getEm().find(Medico.class, m.getIdMedico());
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
}

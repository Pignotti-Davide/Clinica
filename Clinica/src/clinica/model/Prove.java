package clinica.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import clinica.persistence.TipologiaEsameDaoJPA;

public class Prove {
	public static void main(String[] argw){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
	
		TipologiaEsame tipo = new TipologiaEsame();
		TipologiaEsameDaoJPA tipodao = new TipologiaEsameDaoJPA();
		Map<String,String> requisiti = new HashMap<>();
		requisiti.put("18","ciao");
		requisiti.put("sesso", "M");
		tipo.setPrerequisiti(requisiti);
	tipo.setNome("ciao");
	tipo.setDescrizione("dfsffs");
	tipodao.create(tipo);
	em.close();
	emf.close();
	}
}

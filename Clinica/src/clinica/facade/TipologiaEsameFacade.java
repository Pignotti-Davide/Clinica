package clinica.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import clinica.model.TipologiaEsame;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
public class TipologiaEsameFacade {

	private EntityManager em;
	public TipologiaEsameFacade(){

	}
	public TipologiaEsame create(String nome, String descrizione, Map<String, String> prerequisiti) {
		TipologiaEsame esa = new TipologiaEsame();
		esa.setDescrizione(descrizione);
		esa.setNome(nome);
		esa.setPrerequisiti(prerequisiti);
		em.persist(esa);
		return esa;

	}
	public TipologiaEsame getTipologiaEsame(Long id) {
	    TipologiaEsame tipologia = em.find(TipologiaEsame.class, id);
		return tipologia;
	}
	public List<TipologiaEsame> getAllTipologiaEsame() {
        CriteriaQuery<TipologiaEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaEsame.class);
        cq.select(cq.from(TipologiaEsame.class));
        List<TipologiaEsame> lista = em.createQuery(cq).getResultList();
		return lista;
	}

	public void updateTipologiaEsame(TipologiaEsame tipologiaEsame) {
        em.merge(tipologiaEsame);
	}
	
	public void deleteTipologiaEsame(Long id) {
		TipologiaEsame tipologiaEsame = em.find(TipologiaEsame.class, id);
		em.remove(tipologiaEsame);

	}

}

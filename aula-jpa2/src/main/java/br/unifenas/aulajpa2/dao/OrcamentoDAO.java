package br.unifenas.aulajpa2.dao;

import javax.persistence.EntityManager;

import br.unifenas.aulajpa2.model.Orcamento;

public class OrcamentoDAO {
	public void create(Orcamento orcamento) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(orcamento);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Orcamento orcamento) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(orcamento);
		em.getTransaction().commit();
		em.close();
	}
	
	public Orcamento readId(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		Orcamento consultaOrcamento=em.find(Orcamento.class, id);
		em.close();
		return consultaOrcamento;
	}
	
	public void delete(Orcamento orcamento) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Object c=em.merge(orcamento);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
}

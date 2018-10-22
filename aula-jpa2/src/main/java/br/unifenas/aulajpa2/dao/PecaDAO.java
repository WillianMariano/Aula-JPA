package br.unifenas.aulajpa2.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.unifenas.aulajpa2.model.Peca;


public class PecaDAO {
	public void create(Peca peca) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(peca);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Peca peca) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(peca);
		em.getTransaction().commit();
		em.close();
	}
	
	public Peca readId(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		Peca consultaPeca=em.find(Peca.class, id);
		em.close();
		return consultaPeca;
	}
	
	public void delete(Peca peca) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Object c=em.merge(peca);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public Peca buscapecasid(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		return em.createQuery("Peca.buscapecasid", Peca.class).setParameter("id", id).getSingleResult();
	}
}

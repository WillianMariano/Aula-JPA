package br.unifenas.aulajpa2.dao;

import javax.persistence.EntityManager;

import br.unifenas.aulajpa2.model.Carro;
import br.unifenas.aulajpa2.model.Cliente;

public class CarroDAO {
	public void create(Carro carro) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Carro carro) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(carro);
		em.getTransaction().commit();
		em.close();
	}
	
	public Carro readId(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		Carro consultaCarro=em.find(Carro.class, id);
		em.close();
		return consultaCarro;
	}
	
	public void delete(Carro carro) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Object c=em.merge(carro);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	public Carro buscacarroid(int id) {
		EntityManager em=JPAUtil.getEntityManager();
	    String buscaid = "SELECT Carro FROM Carro Carro where Carro.id= :id";
	    return em.createQuery(buscaid, Carro.class).setParameter("id", id).getSingleResult();
	}
}

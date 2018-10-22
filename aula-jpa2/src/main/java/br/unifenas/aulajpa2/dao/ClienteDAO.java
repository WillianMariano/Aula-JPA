package br.unifenas.aulajpa2.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.unifenas.aulajpa2.model.Cliente;

public class ClienteDAO {
	
	public void create(Cliente cliente) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Cliente cliente) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	public Cliente readId(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		Cliente consultaCliente=em.find(Cliente.class, id);
		em.close();
		return consultaCliente;
	}
	
	public void delete(Cliente cliente) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Object c=em.merge(cliente);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public Cliente buscaclienteid(int id) {
		EntityManager em=JPAUtil.getEntityManager();
	    String buscaid = "SELECT Cliente FROM Cliente Cliente where Cliente.id=:id";
	    return em.createQuery(buscaid, Cliente.class).setParameter("id", id).getSingleResult();
	}
}
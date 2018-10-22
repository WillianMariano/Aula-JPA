package br.unifenas.aulajpa2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.unifenas.aulajpa2.model.Endereco;
import br.unifenas.aulajpa2.model.Peca;

public class EnderecoDAO {
	public void create(Endereco endereco) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(endereco);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Endereco endereco) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(endereco);
		em.getTransaction().commit();
		em.close();
	}
	
	public Endereco readId(int id) {
		EntityManager em=JPAUtil.getEntityManager();
		Endereco consultaEndereco=em.find(Endereco.class, id);
		em.close();
		return consultaEndereco;
	}
	
	public void delete(Endereco endereco) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Object c=em.merge(endereco);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Endereco> buscaendereco() {
		EntityManager em=JPAUtil.getEntityManager();
		return (List<Endereco>) em.createNamedQuery("Endereco.buscaendereco", Endereco.class).getResultList();
	}
}

package br.unifenas.aulajpa2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="Peca.buscapecasid", 
		    query="SELECT u FROM Peca u where u.id= :id")
})
@Entity
public class Peca {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private double valor;
	
	public Peca() {	}
	
	public Peca(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}

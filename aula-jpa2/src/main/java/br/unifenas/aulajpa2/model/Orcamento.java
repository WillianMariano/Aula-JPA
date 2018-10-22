package br.unifenas.aulajpa2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orcamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Cliente cliente;
	private double precoMaodeObra;
	@OneToOne
	private Carro carro;
	@OneToMany
	private List<Peca> pecas;
	
	public Orcamento() { }
	
	public Orcamento(Cliente cliente, double precoMaodeObra, Carro carro, List<Peca> pecas) {
		super();
		this.cliente = cliente;
		this.precoMaodeObra = precoMaodeObra;
		this.carro = carro;
		this.pecas = pecas;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecoMaodeObra() {
		return precoMaodeObra;
	}
	public void setPrecoMaodeObra(double precoMaodeObra) {
		this.precoMaodeObra = precoMaodeObra;
	}

	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}	
}

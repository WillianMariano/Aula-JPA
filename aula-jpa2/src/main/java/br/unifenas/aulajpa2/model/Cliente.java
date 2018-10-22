package br.unifenas.aulajpa2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nomecompleto",length=100)
	private String nome;
	private String cpf;
	//@Embedded//inserir no banco os campos de endereço na tabela cliente
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Carro> carros;
	
	public Cliente() { }
	
	public Cliente(String nome, String cpf, Endereco endereco, List<Carro> carros) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.carros = carros;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}

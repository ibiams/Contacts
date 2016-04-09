package br.com.contatos.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "contato")
public class Contato {
	
	private Integer id;
	private String nome;
	private String email;
	
	private List <Telefone> telefones;
	
	public Contato() {}
	
	public Contato(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "conid", unique = true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contatos")
	public List <Telefone> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(List <Telefone> telefones) {
		this.telefones = telefones;
	}
}

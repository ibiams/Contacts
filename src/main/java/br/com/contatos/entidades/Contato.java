package br.com.contatos.entidades;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "contatos")
public class Contato {
	
	@Id @GeneratedValue
	@Column(name = "conid", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "telefones", targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList <Telefone> telefones;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList <Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList <Telefone> telefones) {
		this.telefones = telefones;
	}
}

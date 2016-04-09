package br.com.contatos.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "telefone")
public class Telefone {
	
	private Integer id;
	private Contato contatos;
	private String numero;
	
	public Telefone() {}
	
	public Telefone(String numero) {
		this.numero = numero;
	}	
	
	@Column(name = "numero")
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "telid", unique = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "conid", nullable = false)
	public Contato getContatos() {
		return contatos;
	}

	public void setContatos(Contato contato) {
		this.contatos = contato;
	}
}

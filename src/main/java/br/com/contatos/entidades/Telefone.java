package br.com.contatos.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Telefone {
	
	@Id @GeneratedValue
	@Column(name = "telid", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Contato contato;
	
	@Column(name = "numero")
	private String numero;
	
	public Telefone() {}
	
	public Telefone(Integer id, Contato contato, String numero) {
		this.id = id;
		this.contato = contato;
		this.numero = numero;
	}	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Contato getIdCon() {
		return contato;
	}

	public void setIdCon(Contato contato) {
		this.contato = contato;
	}
}

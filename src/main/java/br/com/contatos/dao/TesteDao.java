package br.com.contatos.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TesteDao {
	
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		
		try{
	         factory = new Configuration().addAnnotatedClass(br.com.contatos.dao.Telefone.class).addAnnotatedClass(br.com.contatos.dao.Contato.class).configure().buildSessionFactory();
	         
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		Telefone telefone = new Telefone ("12344");
		List <Telefone> telefones = new ArrayList <Telefone>();
		
		
		Contato contato = new Contato("Teste2","teste@gmail.com");
		telefone.setContatos(contato);
		telefones.add(telefone);
		//contato.setTelefones(telefones);
		//System.out.println(contato.getTelefones());
		ContatosDAO dao = new ContatosDAO();
		
		//dao.inserirContato(contato);
		
		List <Contato> lista = dao.listarContatos();
		
		for(int i = 0; i < lista.size(); i++){
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getEmail());
			
			if (lista.get(i).getTelefones().size() > 0)
				System.out.println(lista.get(i).getTelefones().get(0).getNumero());
		}
		
		//System.out.println(dao.selecionarTelefonePorNumero("3434383838").getId());
		
//		Contato teste = dao.selecionaContatoPorId(13);
		
//		teste.setNome("Quase");
//		teste.setTelefones(new ArrayList <Telefone>());
//		System.out.println("Sise: " + teste.getTelefones().size());
//		Telefone tel1 = new Telefone("22222");
//		tel1.setContatos(teste);
//		teste.getTelefones().add(tel1);
		
//		Telefone teste3 = new Telefone("101010101");
//		teste3.setId(1);
//		Contato cont = new Contato();
//		cont.setId(8);
//		cont.setNome("Fabio");
//		cont.setEmail("fabio@gmail.com");
//		teste3.setContatos(cont);
//		
//		dao.updateTelefone(teste3);
		
		Telefone teste4 = dao.selecionarTelefonePorId(9);
		
		//teste4.setContatos(dao.selecionarContatoPorId(8));
		
		dao.removerTelefone(teste4);
		
//		
//		teste.setTelefones(dao.listaTelefonesPorIdContato(teste.getId()));
//		
//		System.out.println(teste.getId());
//		System.out.println(teste.getEmail());
//		System.out.println(teste.getTelefones().get(0).getNumero());
		
//		contato = dao.selecionaContatoPorNome("Carlos");
//		
//		Telefone tel = new Telefone();
//		tel.setNumero("12345678");
//		tel.setContatos(contato);
//		
//		dao.inserirTelefone(tel);
		
		
		
		System.out.println("chegou ao fim!");
	}
	
	
	
}

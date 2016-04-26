package br.com.contatos.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BeanSessionFactory {
	
	private static SessionFactory factory;
	
	public void instanciaSessionFactory(){
		
		if (factory == null){
			try{
		         factory = new Configuration().addAnnotatedClass(br.com.contatos.dao.Telefone.class).addAnnotatedClass(br.com.contatos.dao.Contato.class).configure().buildSessionFactory();
		         
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
		}
	}
	
}

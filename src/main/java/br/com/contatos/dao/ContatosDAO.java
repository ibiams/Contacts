package br.com.contatos.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class ContatosDAO {
	
	private static SessionFactory factory;
	
	public void inserirContato(Contato contato){
		
		instanciaSessionFactory();
		Session session = null;
		
		try{
			
			session= factory.openSession(); 
			
			session.beginTransaction();
			session.save(contato);
			session.getTransaction().commit();
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
	}
	
	public void inserirTelefone(Telefone tel){
		
		instanciaSessionFactory();
		Session session = null;
		
		try{
			
			session= factory.openSession(); 
			
			session.beginTransaction();
			session.save("Telefone", tel);
			session.getTransaction().commit();
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
	}
	
	public Contato selecionarContatoPorId (int id) {
		
		instanciaSessionFactory();
		
		Session session = null;
		List<Contato> resultado = null;
		
		try{
			
			session = factory.openSession(); 
			

			Criteria cr = session.createCriteria(Contato.class);
			cr.add(Restrictions.eq("id", id));
			
			resultado = Collections.checkedList(cr.list(), Contato.class);
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
		
		return resultado.get(0);
}
	
	public Contato selecionarContatoPorNome (String nome) {
		
		instanciaSessionFactory();
		
		Session session = null;
		List<Contato> resultado = null;
		
		try{
			
			session = factory.openSession(); 
			

			Criteria cr = session.createCriteria(Contato.class);
			cr.add(Restrictions.eq("nome", nome));
			
			resultado = Collections.checkedList(cr.list(), Contato.class);
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
		
		return resultado.get(0);
	}
	
	public List <Contato> listarContatos(){

		instanciaSessionFactory();
		
		Session session = null;
		List<Contato> resultado = null;
		
		try{
			
			session = factory.openSession(); 
			
			String hql = "FROM Contato";
			Query query = session.createQuery(hql);
			
			resultado = Collections.checkedList(query.list(), Contato.class);
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
		//associa os telefones aos contatos.
		for (int i = 0; i < resultado.size(); i++) {
			resultado.get(i).setTelefones(listarTelefonesPorIdContato(resultado.get(i).getId()));
		}
		
		return resultado;
	}
	
	public Telefone selecionarTelefonePorNumero (String numeroTelefone){
		
		instanciaSessionFactory();
		
		Session session = null;
		List<Telefone> resultado = null;
		
		try{
			
			session = factory.openSession(); 
			

			Criteria cr = session.createCriteria(Telefone.class);
			cr.add(Restrictions.eq("numero", numeroTelefone));
			
			resultado = Collections.checkedList(cr.list(), Telefone.class);
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
		
		return resultado.get(0);
	}
	
	public Telefone selecionarTelefonePorId (int id) {
		
		instanciaSessionFactory();
		
		Session session = null;
		List<Telefone> resultado = null;
		
		try{
			
			session = factory.openSession(); 
			

			Criteria cr = session.createCriteria(Telefone.class);
			cr.add(Restrictions.eq("id", id));
			
			resultado = Collections.checkedList(cr.list(), Telefone.class);
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
		
		return resultado.get(0);
}
	
 	public List <Telefone> listarTelefonesPorIdContato (int idContato){
		
		instanciaSessionFactory();
		
		Session session = null;
		List <Telefone> resultado = null;
		
		try{
			
			session = factory.openSession(); 

			String hql = "FROM Telefone WHERE conid = " + idContato;
			Query query = session.createQuery(hql);
			
			resultado = Collections.checkedList(query.list(), Telefone.class);
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
		return resultado;
	}
	
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
	
	public void atualizarContato (Contato contato){
		
		instanciaSessionFactory();
		Session session = null;
		
		try{
			
			session= factory.openSession(); 
			
			session.beginTransaction();
			session.saveOrUpdate(contato);
			session.getTransaction().commit();
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
	}
	
	public void atualizarTelefone (Telefone tel){
		
		instanciaSessionFactory();
		Session session = null;
		//int resultado;
		
		try{
			
			session= factory.openSession(); 
			
			session.beginTransaction();
			session.saveOrUpdate("Telefone", tel);
			session.getTransaction().commit();
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
	}
	
	public void removerContato (Contato contato){
		
		instanciaSessionFactory();
		Session session = null;
		
		try{
			
			session= factory.openSession(); 
			
			session.beginTransaction();
			session.delete(contato);
			session.getTransaction().commit();
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
	}

	public void removerTelefone (Telefone tel){

		instanciaSessionFactory();
		Session session = null;
		//int resultado;
		
		try{
			
			session= factory.openSession(); 
			
			session.beginTransaction();
			session.delete("Telefone", tel);
			session.flush();
			session.getTransaction().commit();
			
			
		}catch (Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			session.close();
		}
		
	}
}

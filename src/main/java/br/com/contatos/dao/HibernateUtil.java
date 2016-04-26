package br.com.contatos.dao;

import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
 
public class HibernateUtil {
     
    private static LocalSessionFactoryBean sessionFactory;
     
    static{
        try {
            sessionFactory = (LocalSessionFactoryBean) new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }
 
    public static LocalSessionFactoryBean getSessionFactory(){
        return sessionFactory;
    }
     
    public static void shutDown(){
        //closes caches and connections
        //getSessionFactory().close();
    }
}
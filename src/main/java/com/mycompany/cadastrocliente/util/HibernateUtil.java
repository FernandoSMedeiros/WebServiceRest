/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastrocliente.util;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author fernando
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;    
        
    public static SessionFactory getSessionFactory() throws MappingException {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() {       
        return getSessionFactory().openSession();
    }
    
}

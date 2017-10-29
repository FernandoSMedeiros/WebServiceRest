/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cadastrocliente.dao;

import com.mycompany.cadastrocliente.model.Cliente;
import com.mycompany.cadastrocliente.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;

/**
 *
 * @author fernando
 */
public class ClienteDao implements Dao<Cliente>{

    @Override    
    public void salvar(Cliente t) {
       Session session = HibernateUtil.getSession();
            
        try {
            session.getTransaction().begin();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel salvar");
        } finally{
            session.close();
        }         
                   
    }

    @Override
    public void deletar(Cliente t) {
        
        Session session = HibernateUtil.getSession();
            
        try {
            session.getTransaction().begin();
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Não foi possivel deletar");
        } finally{
            session.close();
        }
               
    }

    @Override
    public Cliente buscar(int id) {
        
        Session session = HibernateUtil.getSession();
           
        Cliente cliente = session.find(Cliente.class, id);
           
        if (cliente != null){
            return cliente;
        }else{  
            session.close();
            throw new NoResultException("Não há cliente com este ID");            
        }
           
    }

    @Override
    public List<Cliente> listarTodos() {
        
        String query = "from Cliente";
        List<Cliente> clientes = new ArrayList<>();        
        
        Session session = HibernateUtil.getSession();        
        
        clientes = session.createQuery(query, Cliente.class)                      
                      .getResultList();
            
        if(clientes.isEmpty() == false){
            return clientes;
        }else{            
            session.close();
            throw new NoResultException("Não foi possivel listar");        
        } 
        
    }

    @Override
    public void atualizar(Cliente t) {
        
        Session session = HibernateUtil.getSession();
        
        try{
            session.getTransaction().begin();
            session.merge(t);
            session.getTransaction().commit();
        }catch(Exception e){            
            System.out.println("Não foi possivel atualizar cliente " + e);
        }finally{
            session.close();
        }
        
    }
    
}

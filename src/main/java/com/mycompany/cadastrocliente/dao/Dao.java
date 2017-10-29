
package com.mycompany.cadastrocliente.dao;

import java.util.List;


public interface Dao <T>{
  
    public void salvar(T t);
    public void atualizar(T t);
    public void deletar(T t);
    public T buscar(int id);
    public List<T> listarTodos();
    
}

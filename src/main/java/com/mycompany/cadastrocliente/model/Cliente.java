
package com.mycompany.cadastrocliente.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente implements Serializable{
    
    @Id
    private Integer id;
    private String nome;    

    public Cliente() {
    }

    public Cliente(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", id=" + id + '}';
    }
    
}


package com.mycompany.cadastrocliente.controller;

import com.google.gson.Gson;
import com.mycompany.cadastrocliente.dao.ClienteDao;
import com.mycompany.cadastrocliente.dao.Dao;
import com.mycompany.cadastrocliente.model.Cliente;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author fernando
 */
@Path("clientes")
public class ClienteController {
   
    Gson gson = new Gson();
    Dao<Cliente> dao = new ClienteDao();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public String list(){
        
        List<Cliente> clientes = dao.listarTodos();        
        return gson.toJson(clientes);
        
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}/")
    public String cliente(@PathParam("id") int id){
        return gson.toJson(dao.buscar(id));    
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response criar(String json){
    
        Cliente cliente = gson.fromJson(json, Cliente.class);        
        dao.salvar(cliente);
        
        return Response.status(Response.Status.OK).build();
       
    }
    
    @PUT   
    @Path("/")
    public Response update(String json){
    
        Cliente cliente = gson.fromJson(json, Cliente.class);        
        dao.atualizar(cliente);
        
        return Response.status(Response.Status.OK).build();
        
    } 
    
    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") int id){
    
        Cliente cliente = dao.buscar(id);        
        dao.deletar(cliente);
        
        return Response.status(Response.Status.OK).build();
        
    }
    
}

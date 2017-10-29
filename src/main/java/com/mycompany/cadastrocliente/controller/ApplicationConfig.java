
package com.mycompany.cadastrocliente.controller;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class ApplicationConfig extends ResourceConfig {

    
    public ApplicationConfig() {
       packages("com.mycompany.cadastrocliente.controller");
   }

    
    
   
    
}

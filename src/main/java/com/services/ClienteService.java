package com.services;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


import com.dao.EmpleadoDAO;
import com.entity.Empleado;
import com.general.Status;

@Path("empleados/")
public class ClienteService {
	
      Empleado empleado = null;
      EmpleadoDAO dao = null;
      
      @Path("mostrar")
      @GET
      @Produces({MediaType.APPLICATION_JSON})
      public List<Empleado> mostrar(){
    	  
    	  dao = new EmpleadoDAO();
    	  List<Empleado> list = dao.mostrar();
    	  System.out.println("datos: " + list);
    	  return list;  	  
      }
      
      @Path("guardar")
      @POST
      @Consumes({MediaType.APPLICATION_JSON})
      @Produces({MediaType.APPLICATION_JSON})
      public Status guardar(Empleado e) {
    	  
    	  System.out.println("empleado a guardar: "+e);
    	  Status state = new Status();
    	  state.setOb(e);
    	  
    	  dao = new EmpleadoDAO();
    	  String res = dao.guardar(e);
    	  
    	  if(res.equals("1")) {
    		  state.setMensaje("Guardado exitosamente");
    		  state.setRespuesta(res);
    	  }else {
    		  state.setMensaje("No fue posible guardar");
    		  state.setRespuesta(res);
    	  }
    	  
    	  return state;
      }
      
      
      @Path("eliminar/{id}")
      @GET
      @Produces({MediaType.APPLICATION_JSON})
      public Status eliminar(@PathParam("id")  int id) {
    	  Status state = new Status();
    	  state.setOb(id);
    	  
    	  dao = new EmpleadoDAO();
    	  String res = dao.eliminar(id);
    	  
    	  if(res.equals("1")) {
    		  state.setMensaje("Eliminado exitosamente");
    		  state.setRespuesta(res);
    	  }else {
    		  state.setMensaje("No fue posible guardar");
    		  state.setRespuesta(res);
    	  }
    	  
    	  return state;
      }
      
      
      @Path("editar")
      @POST
      @Consumes({MediaType.APPLICATION_JSON})
      @Produces({MediaType.APPLICATION_JSON})
      public Status editar(Empleado e) {
    	  
    	  Status state = new Status();
    	  state.setOb(e);
    	   	  
    	  dao = new EmpleadoDAO();
    	  String res = dao.editar(e);
    	  
    	  if(res.equals("1")) {
    		  state.setMensaje("Actualizado exitosamente");
    		  state.setRespuesta(res);
    	  }else {
    		  state.setMensaje("No fue posible actualizar este registro");
    		  state.setRespuesta(res);
    	  }
    	  
    	  return state;
      }
      
      
      @Path("buscar-por-id/{id}")
      @GET
      @Consumes({MediaType.APPLICATION_JSON})
      @Produces({MediaType.APPLICATION_JSON})    
      public Empleado buscar(@PathParam("id") int id) {
    	  
    	  dao = new EmpleadoDAO();
    	  empleado = (Empleado) dao.buscar(id);
    	  System.out.println("Se encontro el registro");
    	  return empleado;
      }
      
      
}

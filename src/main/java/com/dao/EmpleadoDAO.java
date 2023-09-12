package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.entity.Empleado;
import com.general.Metodos;

public class EmpleadoDAO implements Metodos {
	
	//carga los objetos (la clase definida en el persistence)
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tables");
	//carga todas las operaciones (insert,update,delete,select,contar ,etc.)
	EntityManager em = emf.createEntityManager();
	Empleado empleado = null;
	
	@Override
	public String guardar(Object ob) {
		empleado = (Empleado) ob;
		em.getTransaction().begin();
		String resultado=null;
		
		try {
			em.persist(empleado);//este es el insert
			em.getTransaction().commit();
			resultado="1";
			System.out.println("Registro insertado");
			
		}catch(Exception e) {
			em.getTransaction().rollback();
			resultado = e.getMessage();
			System.out.println("No pudo insertarse");
		}
		em.close();//es importante cerrar el EntityManager para liberar memoria
		return resultado;
	}
	
	@Override
	public String editar(Object ob) {
		empleado = (Empleado) ob;
		//En el caso de actualizar, primero tenemos que cargar un objeto con la información “vieja”, es decir, la que ya
		//existe en db
		Empleado empleados = em.find(Empleado.class,empleado.getEmpleadoId());
        String r = null;
        em.getTransaction().begin();//principio de la transaccion
       
        try {
        	empleados.setNombre(empleado.getNombre());
			empleados.setFecha(empleado.getFecha());
			empleados.setSalario(empleado.getSalario());
			em.getTransaction().commit();//ejecucion exitosamente,se comprometen los cambios
			System.out.println("Editado correctamente");
			r  ="1";
		} catch (Exception e) {
			
			em.getTransaction().rollback();//indica que hubo alguna falla en el proceso de transaccion
			System.out.println("No se puede editar");
			r = e.getMessage();
		}
        return r;
	}
	
	
	@Override
	public  String eliminar(int id) {

		String r = null;
		empleado = em.find(Empleado.class,id);
		em.getTransaction().begin();
		
		try {
			em.remove(empleado);
			em.getTransaction().commit();
			System.out.println("Se ha eliminado el registro");
			r ="1";
			
		} catch (Exception e) {
			
			em.getTransaction().rollback();
	        System.out.println("No se pudo eliminar");
	        r = e.getMessage();
		}
		return r;
	}
	
	
	@Override
	public Object buscar(int id) {
		empleado = em.find(Empleado.class,id);
		return empleado;
	}
	
	@Override
	public List mostrar() {
		
		List<Empleado> ls = em.createQuery("from Empleado").getResultList();
		return ls;
	}

}

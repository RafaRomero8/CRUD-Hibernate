package com.entity;

import java.sql.Date;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="EMPLEADOS")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Empleado {
	
	public Empleado() {}
	
	public Empleado(int id) {
		this.empleadoId = id;		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="cid_empleado")
	@SequenceGenerator(name="cid_empleado",sequenceName="SQ_EMPLEADOS")
	@Column(name="EMPLEADO_ID",columnDefinition="NUMBER")
	int empleadoId;
	
	
	@Column(name="NOMBRE",columnDefinition="NVARCHAR2(15)")
	String nombre;
	@Column(name="FECHA_INGRESO",columnDefinition="DATE")
	Date fecha;
	@Column(name="SALARIO",columnDefinition="NUMBER(5,2)")
	double salario;
	
	
	
	//@ManyToOne
	// @JoinColumn(name = "DEPTO_ID")
	// private Departamento dep;
	 
	@OneToMany(mappedBy="emp")
	 private List<Departamento> dep;
	
	

	public List<Departamento> getDep() {
		return dep;
	}

	public void setDep(List<Departamento> dep) {
		this.dep = dep;
	}

	public Empleado(int empleadoId, String nombre, Date fecha, double salario, List<Departamento> dep) {
		super();
		this.empleadoId = empleadoId;
		this.nombre = nombre;
		this.fecha = fecha;
		this.salario = salario;
		this.dep = dep;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	
	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [empleadoId=" + empleadoId + ", nombre=" + nombre + ", fecha=" + fecha + ", salario=" + salario
				+ "]";
	}

	


}

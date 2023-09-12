package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="DEPARTAMENTO")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="DEPTO_ID")

public class Departamento {
	
	public Departamento() {}
	
	public Departamento(int depa) {
		
		this.departamento_id = depa; 
	}
	
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="gen_departamento")
	@SequenceGenerator(name="gen_departamento",sequenceName="SQ_DEPARTAMENTO")
	@Column(name="DEPTO_ID",columnDefinition="NUMBER")
	int departamento_id;
	
	@Column(name="EMPLEADO_ID",columnDefinition="NUMBER")
	int empleado;
	
	@Column(name="NOMBRE",columnDefinition="NVARCHAR2(20)")
	String dep;
	
	/*
	 * 	 //@OneToMany(mappedBy="dep")
	  //  @JoinColumn(name = "EMPLEADO_ID")
	//private List<Empleado> emp = new ArrayList<Empleado>();
      //private Empleado emp;
	 * */

	
	 @ManyToOne
	 @JoinColumn(name = "EMPLEADO_ID",insertable = false, updatable = false)
	 private Empleado emp;


	public Empleado getEmp() {
		return emp;
	}

	public void setEmp(Empleado emp) {
		this.emp = emp;
	}

	public Departamento(int departamento_id, int empleado, String dep, Empleado emp) {
		super();
		this.departamento_id = departamento_id;
		this.empleado = empleado;
		this.dep = dep;
		this.emp = emp;
	}

	public int getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(int departamento_id) {
		this.departamento_id = departamento_id;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Departamento [departamento_id=" + departamento_id + ", empleado=" + empleado + ", dep=" + dep + ", emp="
				+ emp + "]";
	}

	

	

	

	

	
	 

}

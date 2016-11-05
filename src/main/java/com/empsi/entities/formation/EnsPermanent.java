package com.empsi.entities.formation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class EnsPermanent extends Enseignant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double salaireMensuel;
	public EnsPermanent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double getSalaireMensuel() {
		return salaireMensuel;
	}
	public void setSalaireMensuel(double salaireMensuel) {
		this.salaireMensuel = salaireMensuel;
	}
	
	
}

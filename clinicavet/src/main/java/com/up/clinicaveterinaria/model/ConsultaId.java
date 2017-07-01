package com.up.clinicaveterinaria.model;

import java.io.Serializable;
import java.util.Date;

//@Embeddable
public class ConsultaId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5577994665849695515L;
	
//	@OneToMany
//	@JoinColumn(name="ANIMAL_ID", referencedColumnName="id")
	private Animal animal;
	private Date dataHoraConsulta;
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Date getDataHoraConsulta() {
		return dataHoraConsulta;
	}
	
	public void setDataHoraConsulta(Date dataHoraConsulta) {
		this.dataHoraConsulta = dataHoraConsulta;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((dataHoraConsulta == null) ? 0 : dataHoraConsulta.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaId other = (ConsultaId) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (dataHoraConsulta == null) {
			if (other.dataHoraConsulta != null)
				return false;
		} else if (!dataHoraConsulta.equals(other.dataHoraConsulta))
			return false;
		return true;
	}	
}
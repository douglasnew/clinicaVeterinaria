package com.up.clinicaveterinaria.DAO;

import com.up.clinicaveterinaria.model.TipoAnimal;

public class TipoAnimalDAO extends GenericDAO<Integer, TipoAnimal> {
	
	public TipoAnimalDAO() {
		super(TipoAnimal.class);
	}

}

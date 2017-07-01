package com.up.clinicaveterinaria.DAO;

import com.up.clinicaveterinaria.model.VacinaAnimal;

public class VacinaAnimalDAO extends GenericDAO<Integer, VacinaAnimal> {
	
	public VacinaAnimalDAO() {
		super(VacinaAnimal.class);
	}
}

package com.up.clinicaveterinaria.DAO;

import com.up.clinicaveterinaria.model.Especie;

public class EspecieDAO extends GenericDAO<Integer, Especie> {
	
	public EspecieDAO() {
		super(Especie.class);
	}

}

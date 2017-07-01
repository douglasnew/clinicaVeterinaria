package com.up.clinicaveterinaria.DAO;

import com.up.clinicaveterinaria.model.Vacina;

public class VacinaDAO extends GenericDAO<Integer, Vacina> {
	
	public VacinaDAO() {
		super(Vacina.class);
	}
}

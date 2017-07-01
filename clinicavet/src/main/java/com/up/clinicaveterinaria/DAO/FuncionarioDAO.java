package com.up.clinicaveterinaria.DAO;

import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Integer, Funcionario> {
	
	public FuncionarioDAO() {
		super(Funcionario.class);
	}

}

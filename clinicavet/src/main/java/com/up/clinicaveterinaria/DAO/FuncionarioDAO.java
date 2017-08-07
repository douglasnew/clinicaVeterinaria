package com.up.clinicaveterinaria.DAO;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.up.clinicaveterinaria.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Integer, Funcionario> {
	
	public FuncionarioDAO() {
		super(Funcionario.class);
	}
	
	public List<Funcionario> listarVeterinario()
	{
		Query query = super.getEntityManager().createNamedQuery("Funcionario.listarVeterinario");
		
		try {
			List<Funcionario> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException e) {
			return null;
		}
	}

}

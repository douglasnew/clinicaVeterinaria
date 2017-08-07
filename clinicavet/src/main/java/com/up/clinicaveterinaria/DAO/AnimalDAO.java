package com.up.clinicaveterinaria.DAO;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.TipoAnimal;

public class AnimalDAO extends GenericDAO<Integer, Animal> {

	public AnimalDAO() {
		super(Animal.class);
	}
	
	public List<Animal> listar() {
		String sql = "select a from Animal a";
		Query query = super.getEntityManager().createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Animal> retorno = query.getResultList();
		return retorno;
	}
	
	public List<Animal> bucarAnimalPorAlergia(Integer id) {
		String sql = "select a from Animal a"
				+ " inner join fetch a.alergias al"//fetch = carga eagger
				+ " where al.id = :id";
//				+ " group by a";//RELIZAR O INNER JOIN COMO SE NO BANCO
		TypedQuery<Animal> query = super.getEntityManager().createQuery(sql, Animal.class);
		query.setParameter("id", id);
		try {
			List<Animal> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
		
//		Query query = super.getEntityManager().createQuery(sql);
//		query.setParameter("id", id);
//
//		@SuppressWarnings("unchecked")
//		List<Animal> retorno = query.getResultList();
//		return retorno;
	}
	
	public List<Animal> listarAnimaisDoTipo(String acronimoTipo) 
	{
		Query query = super.getEntityManager().createNamedQuery("Animal.listarAnimaisDoTipo");
		query.setParameter("acronimoTipo", acronimoTipo);
		
		try {
			List<Animal> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException e) {
			return null;
		}
	}
}

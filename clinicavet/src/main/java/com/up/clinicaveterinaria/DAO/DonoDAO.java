package com.up.clinicaveterinaria.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.up.clinicaveterinaria.model.Dono;

public class DonoDAO extends GenericDAO<Integer, Dono> {

	public DonoDAO() {
		super(Dono.class);
	}

	public List<Dono> listar() {
		String sql = "select d from Dono d";
		Query query = super.getEntityManager().createQuery(sql);

		@SuppressWarnings("unchecked")
		List<Dono> retorno = query.getResultList();
		return retorno;
	}

	public List<Dono> listarPessoasQuePossuemTipoAnimal(String acronimo) {
		String sql = "select d from Dono d" + " inner join d.animais a" + " where a.especie.tipoAnimal.acronimo = :acro"
				+ " group by d";
		Query query = super.getEntityManager().createQuery(sql);
		query.setParameter("acro", acronimo);

		@SuppressWarnings("unchecked")
		List<Dono> retorno = query.getResultList();
		return retorno;
	}

	public Dono findEager(Integer id) {
		String sql = "select d from Dono d " + " inner join fetch d.animais" + " where d.id = :idDono";
		TypedQuery<Dono> query = super.getEntityManager().createQuery(sql, Dono.class);
		query.setParameter("idDono", id);
		try {
			Dono retorno = query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public List<Dono> listarPessoas(String nomeCidade, Date nascidoDepoisDe) {
		String sql = "select d from Dono d" + " inner join fetch d.endereco" + " where d.endereco.cidade = :cidDono"
				+ " and d.nascimento < :nascDono";
		TypedQuery<Dono> query = super.getEntityManager().createQuery(sql, Dono.class);
		query.setParameter("cidDono", nomeCidade);
		query.setParameter("nascDono", nascidoDepoisDe);
		try {
			List<Dono> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Dono findByCPF(Long cpf) {
		Query query = super.getEntityManager().createNamedQuery("Dono.findBycpf");
		query.setParameter("cpf", cpf);

		Dono retorno = (Dono) query.getSingleResult();
		return retorno;
	}

	public List<Dono> listarMoradores(String cidade, boolean ordenacaoAscendente) {
		
		Query query;
		if(ordenacaoAscendente == true) {
			query = super.getEntityManager().createNamedQuery("Dono.listarMoradoresAsc");
		} else {
			query = super.getEntityManager().createNamedQuery("Dono.listarMoradoresAsc");
		}
		query.setParameter("cidade", cidade);

		try {
			List<Dono> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}
}

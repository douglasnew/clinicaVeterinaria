package com.up.clinicaveterinaria;

import java.util.List;

import com.up.clinicaveterinaria.DAO.DonoDAO;
import com.up.clinicaveterinaria.DAO.GenericDAO;
import com.up.clinicaveterinaria.model.Dono;

public class Main {
	public static void main(String[] args) {

		DonoDAO donoDAO = new DonoDAO();
//		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//		AnimalDAO animalDAO = new AnimalDAO();
		try {
			donoDAO.beginTransaction();
			List<Dono> donos = donoDAO.listarMoradores("Curitiba", false);
//			for (Animal a : animais) {
//				System.out.println(a.getNome());
//			}
			for (Dono d : donos) {
				System.out.println(d.getNome());
			}
//			System.out.println(f.getNome());
//			List<Dono> donos = donoDAO.listarPessoas("Curitiba", new Date(01,01,1980));
//			for (Dono d : donos) {
//				System.out.println(d.getNome());
//			}
			donoDAO.commitAndCloseTransaction();

//			animalDAO.beginTransaction();
//			List<Animal> animais = animalDAO.bucarAnimalPorAlergia(1);
//			for (Animal a : animais) {
//				System.out.println(a.getNome());
//				for (Alergia alergia : a.getAlergias()) {
//					System.out.println(alergia.getNomeAlergia());
//
//				}
//				System.out.println();
//			}
//			animalDAO.commitAndCloseTransaction();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!");
	}
}
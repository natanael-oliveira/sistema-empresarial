package com.sistema_empresarial.resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.sistema_empresarial.model.Funcionario;
import com.sistema_empresarial.tableModel.FuncionarioTableModel;
import com.sistema_empresarial.util.JPAConnector;

public class FuncionarioResource {
	
	private EntityManager manager = JPAConnector.getInstance().getEntityManager();
	
	public void save(Funcionario funcionario) {
		manager.getTransaction().begin();
		manager.persist(funcionario);
		manager.getTransaction().commit(); 
	}
	public List<Funcionario> list() {
		List<Funcionario> funcionarios = new ArrayList<>();
		Query query = manager.createQuery("SELECT f FROM Funcionario f");
		funcionarios = (List<Funcionario>) query.getResultList();
		return funcionarios;
	}
	public List<Funcionario> listFilter(String filter) {
		List<Funcionario> funcionarios = new ArrayList<>();
		Query query = manager.createQuery("SELECT f FROM Funcionario f WHERE f.name LIKE :args OR f.name LIKE CONCAT(:args,'%') OR f.name LIKE CONCAT('%',:args,'%') OR f.name LIKE CONCAT(:args,'%')",Funcionario.class);
		query.setParameter("args",filter);
		funcionarios = (List<Funcionario>) query.getResultList();
		System.out.println(funcionarios.size());
		return funcionarios;
	}
	public Funcionario getById(Long id) {
		try {
			Funcionario funcionario = manager.find(Funcionario.class,id);
			return funcionario;
		}catch(Exception e) {
			
		}
		return null;
	}
	public boolean remove(Long id) {
		try {
			Funcionario funcionario = getById(id);
			int opc = JOptionPane.showConfirmDialog(null, "Deseja mesmo Deletar o Funcionário "+funcionario.getName()+"?","Deletar Funcionário", 0);
			if (opc == 0) {
				manager.getTransaction().begin();
				manager.remove(funcionario);
				manager.getTransaction().commit();	
				return true;
			}
		}catch(NullPointerException e) {
			System.out.println("Usuário não encontrado!");
		}
		return false;
	}
	public void merge(Funcionario funcionario) {
		manager.getTransaction().begin();
		manager.merge(funcionario);
		manager.getTransaction().commit();
	}
}

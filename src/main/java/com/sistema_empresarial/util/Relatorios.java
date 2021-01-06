package com.sistema_empresarial.util;

import java.util.ArrayList;
import java.util.List;

import com.sistema_empresarial.model.Relatorio;

public class Relatorios {
	private static List<Relatorio> relatorios = new ArrayList<Relatorio>();
	private static Relatorios instance;
	
	public static Relatorios getInstance() {
		if(instance == null) {
			return instance = new Relatorios();
		}
		return instance;
	}
	private Relatorios(){
		relatorios.add(new Relatorio("Lista de Funcionários","relatorios/funcionarios.jrxml"));
	}
	public static List<Relatorio> getRelatorios() {
		getInstance();
		return relatorios;
	}	
}

package com.sistema_empresarial.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Relatorio {
	
	private String name;
	private String path;
	
	public Relatorio() {}
	
	public Relatorio(String name,String path) {
		this.name = name;
		this.path = path;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}

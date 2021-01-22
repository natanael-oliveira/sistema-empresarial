package com.sistema_empresarial.resource;

import javax.swing.JOptionPane;

import com.sistema_empresarial.model.Usuario;
import com.sistema_empresarial.view.Dashboard;

public class UsuarioResource {
	Usuario usuario = new Usuario();
	public boolean login(String usuario,String senha) {
		if(verificaDados(usuario,senha)) {
			Dashboard dashboard = new Dashboard();
			dashboard.setVisible(true);
			return true;
		}
		return false;
	}
	public boolean verificaDados(String usuario,String senha) {
		if(this.usuario.getUsuario().equals(usuario) && this.usuario.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}
}

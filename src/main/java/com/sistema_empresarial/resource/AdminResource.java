package com.sistema_empresarial.resource;

import javax.swing.JOptionPane;

import com.sistema_empresarial.model.Admin;
import com.sistema_empresarial.view.Dashboard;

public class AdminResource {
	public boolean login(String user,String password) {
		Admin admin = new Admin();
		if(password.equals(admin.getPassword()) && user.equals(admin.getUser())) {
			Dashboard dashboard = new Dashboard();
			dashboard.setVisible(true);
			return true;
		}
		JOptionPane.showMessageDialog(null,"Usuário ou Senha incorreta!");
		return false;
	}
}

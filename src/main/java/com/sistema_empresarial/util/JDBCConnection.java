package com.sistema_empresarial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sistema_empresarial.model.Funcionario;

public class JDBCConnection{
	
	private static JDBCConnection instance;
	private String db = "sistemaempresarial";
	private String user = "root";
	private String password = "root";
	private String host = "localhost";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://"+host+":3306/"+db+"?serverTimezone=GMT-3";
	private Connection conn;
	
	private JDBCConnection() {
		connection();
	}
	
	public static JDBCConnection getInstance() {
		if(instance == null) {
			return instance = new JDBCConnection(); 
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	private Connection connection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void list() throws SQLException{
		PreparedStatement ps = getConnection().prepareStatement("select * from funcionario");
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			System.out.println(result.getString("name"));
		}
	}
}

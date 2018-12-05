package br.ifsp.login.dao;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;

public class ConnectionFactory {
	
	public static Connection createConnection () {
		
		String stringDeConexao = "jdbc:mysql://localhost:3306/login";
		String usuario = "root";
		String senha = "";
		
		Connection conexao = null ;
		
		try {
			
			conexao = 
			DriverManager.getConnection(stringDeConexao, usuario, senha);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao ;
	}
}
